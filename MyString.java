import java.util.Arrays;

public class MyString {
    private char[] chars;

    public MyString(String str) {
        chars = str.toCharArray();
    }

    public int compareTo(String str) {
        if (chars.length != str.length()) {
            return chars.length - str.length();
        }
        for (int i = 0; i < str.length(); i++) {
            if (chars[i] != str.charAt(i)) {
                return chars[i] - str.charAt(i);
            }
        }
        return 0;
    }

    public boolean contains(String str) {
        if  (chars.length < str.length()) {
            return false;
        }
        int temp = 0;
        int len = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == str.charAt(temp)) {
                if (str.length() == 1) {
                    return true;
                }
                if (i < chars.length - 1 && chars[i + 1] == str.charAt(temp + 1)) {
                    len++;
                }
                if (temp < str.length() - 1) {
                    temp++;
                }
                if (i == chars.length - 1) {
                    len++;
                }
            }
        }
        if (len == str.length()) {
            return true;
        }
        return false;
    }

    public int myIndexOf(String str) {
        if (chars.length < str.length()) {
            return -1;
        }
        int temp = 0;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == str.charAt(temp)) {
                if (str.length() == 1) {
                    return i;
                }
                if (i < chars.length - 1 && chars[i + 1] != str.charAt(temp + 1)) {
                    return -1;
                }
                if (temp < str.length() - 1) {
                    temp++;
                }
                if (temp == str.length() - 1) {
                    index = i + 2;
                    break;
                }
            }
        }
        return index - str.length();
    }

    public String[] split(String str) {
        String[] strings = new String[10];
        StringBuilder temp = new StringBuilder();
        for (char c:chars) {
            temp.append(c);
        }
        temp.append(" ");
        String temp2 = temp.toString();
        int num = 0;
        while (temp2.contains(str)) {
            int index = temp2.indexOf(str);
            if (num == strings.length) {
                strings = Arrays.copyOf(strings, 2 * strings.length);
            }
            temp.replace(0,temp.length(),"");
            for (int i = 0; i < index; i++) {
                temp.append(temp2.charAt(i));
            }
            strings[num++] = temp.toString();
            temp.replace(0,temp.length(),"");
            for (int i = index + 1; i < temp2.length(); i++) {
                temp.append(temp2.charAt(i));
            }
            temp2 = temp.toString();
        }
        String[] realStrings = new String[num];
        for (int i = 0; i < num; i++) {
            realStrings[i] = strings[i];
        }
        if (realStrings.length == 1) {
            return new String[]{ };
        }
        return realStrings;
    }
}

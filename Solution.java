import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public String longestPalindrome(String s) {
        ArrayList<String> list = new ArrayList<>();
        Stack<Character> stark = new Stack<>();
        for (int i = 0;i < s.length(); i++) {
            int lead = 0;
            if (stark.isEmpty() || (!stark.peek().equals(s.charAt(i)) && !stark.peek().equals(s.charAt(i + 1)))) {
                stark.push(s.charAt(i));
            } else {
                StringBuilder sb = new StringBuilder(stark.pop());
                while (stark.peek().equals(s.charAt(i++))) {
                    sb.append(stark.pop());
                    sb.append(s.charAt(i));
                    lead++;
                }
                if (lead != 0) {
                    i--;
                    list.add(sb.toString());
                    continue;
                }
                while (stark.peek().equals(s.charAt(++i + 1))){
                    sb.append(s.charAt(i + 1));
                    sb.append(s.charAt(i));
                    sb.append(stark.pop());
                }
                i--;
                list.add(sb.toString());
            }
        }
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            if (str.length() < list.get(i).length()) {
                str = list.get(i);
            }
        }
        return str;
    }
}

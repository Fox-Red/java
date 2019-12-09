public class TestString {
    public static void main(String[] args) {
        MyString s1 = new MyString("");
//        System.out.println(s1.compareTo("worrd"));
//        System.out.println(s1.contains("wd"));
//        System.out.println(s1.indexOf("world"));
        String[] s = s1.split(" ");
        for (String str:s) {
            System.out.println(str);
        }
    }

}

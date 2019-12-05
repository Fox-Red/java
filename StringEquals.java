import java.util.Stack;

public class StringEquals {
    public static void main(String[] args) {
        String s = "";
        StringEquals se = new StringEquals();
        int size = se.number(s);
        System.out.println(size);
    }

    public int number(String s) {
        int size = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.empty()) {
                stack.push(c);
                size++;
            } else {
                Character t = c;
                if (stack.peek().equals(t)) {
                    stack.push(c);
                }else {
                    stack.pop();
                }
            }
        }
        return size;
    }
}

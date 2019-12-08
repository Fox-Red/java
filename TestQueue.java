import java.util.Stack;

public class TestQueue {
    private Stack<Integer> st1 = new Stack();
    private Stack<Integer> st2 = new Stack();

    public void push(Integer element) {
        st1.push(element);
    }

    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }

    private void move() {
        for (int i = 0; i < st1.size(); i++) {
            st2.push(st1.pop());
        }
    }

    public int pop() {
        if (st2.isEmpty()) {
            this.move();
        }
        return st2.pop();
    }

    public int peek() {
        if (st2.isEmpty()) {
            this.move();
        }
        return st2.peek();
    }
}

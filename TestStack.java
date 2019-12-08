import java.util.LinkedList;
import java.util.Queue;

public class TestStack {
    private Queue<Integer> queue = new LinkedList<>();

    public void push(Integer element) {
        queue.offer(element);
    }

    public int top() {
        if (queue.isEmpty()) {
            throw new StackNullException("StackIsEmpty");
        }
        Integer temp = null;
        for (int i = 0; i < queue.size(); i++) {
            temp = queue.poll();
            queue.offer(temp);
        }
        return temp;
    }

    public int pop() {
        if (queue.isEmpty()) {
            throw new StackNullException("StackIsEmpty");
        }
        Integer temp = null;
        for (int i = 0; i < queue.size() - 1; i++) {
            temp = queue.poll();
            queue.offer(temp);
        }
        temp = queue.poll();
        return temp;
    }

    public boolean empty() {
        boolean isEmpty = queue.isEmpty();
        return isEmpty;
    }
}

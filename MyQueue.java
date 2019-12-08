import java.util.LinkedList;

public class MyQueue {
    private LinkedList<Integer> linkedList = new LinkedList<>();

    public void offer(int element) {
        linkedList.add(element);
    }

    public Integer poll() {
        if (linkedList.isEmpty()) {
            return null;
        }
        return linkedList.remove(0);
    }

    public Integer peek() {
        if (linkedList.isEmpty()) {
            return null;
        }
        return linkedList.getFirst();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}

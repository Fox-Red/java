public class MyQueueImprove {
    private class Node {
        private int value;
        private Node next;

        public Node(int value,Node next) {
            this.next = next;
            this.value = value;
        }

        public Node(int value) {
            this(value, null);
        }
    }

    private Node first = null;
    private Node tail = null;
    private int size = 0;

    public void push(int element) {
        Node node = new Node(element);
        if (first == null) {
            first = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public Integer pop() {
        if (first == null) {
            tail =null;
            return null;
        }
        int val = first.value;
        first = first.next;
        size--;
        return val;
    }

    public Integer peek() {
        if (first == null) {
            return null;
        }
        return first.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

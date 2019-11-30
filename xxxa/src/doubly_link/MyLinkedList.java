package doubly_link;

public class MyLinkedList {
    private Node head;
    private Node last;
    private int size;

    public int getSize() {
        return this.size;
    }

    private class Node {
        private int val;
        private Node prev;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

    }

    public void pushFirst(int val) {
        Node node = new Node(val);
        if (head != null) {
            node.next = head;
            head.prev = node;
        }else {
            last = node;
        }
        head = node;
        size++;
    }

    public void popFirst() {
        head = head.next;
        if (head != null) {
            head.prev = null;
        }else {
            last = null;
        }
    }

    public void pushBack(int val) {
        Node node = new Node(val);
        if (head != null) {
            last.next = node;
            node.prev = last;
        }else {
            head = node;
        }
        last = node;
    }

    public void popBack() {
        if (last.prev == null) {
            head = null;
        }else {
            last.prev.next = null;
        }
        last = last.prev;
    }

    public void disPlay() {
        Node cur = head;
        System.out.print("[");
        for (;cur != null;cur = cur.next) {
            System.out.print(cur.val);
            if (cur.next != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

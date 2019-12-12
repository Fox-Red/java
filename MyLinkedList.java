public class MyLinkedList {
    private class Node {
        private Node next;
        private int val;
        public Node(int val) {
            this.val =val;
        }
    }
    private Node myListHead;
    private int size = 0;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        myListHead = new Node(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {

        if (size <= index || index < 0) {
            return -1;
        }
        Node tempHead = myListHead.next;
        for (int i = 0; i < index; i++) {
            tempHead = tempHead.next;
        }
        return tempHead.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            addAtHead(val);
        }
        Node node = new Node(val);
        Node temp = myListHead;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= 0 && index < size) {
            Node prev = myListHead;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            if (prev.next != null) {
                prev.next = prev.next.next;
            }
            size--;
        }
    }
}

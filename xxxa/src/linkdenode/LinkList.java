package linkdenode;

public class LinkList {
    public Node head = null;





    public void disPlay(Node head) {
        System.out.print("[");
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val);
            if (cur.next != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void addFirst(int val) {
        Node cur = new Node(val);
        if (head == null) {
            head = cur;
        }else {
            cur.next = head;
            head = cur;
        }
    }
    public Node mergeTwoLists(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 ==  null) {
            return head1;
        }
        Node cur1 = head1;
        Node cur2 = head2;



        return null;
    }

    public static Node copy(Node head) {
        Node cur = head;
        Node newHead = new Node(0);
        Node newTail = newHead;
        while (cur != null) {
            Node node = new Node(cur.val);
            newTail.next = node;
            newTail = node;
            cur = cur.next;
        }
        return newHead.next;
    }

    public Node partions(Node head, int val) {
        Node cur = head;
        Node smallHead = null;
        Node smallTail = smallHead;
        Node bigHead = null;
        Node bigTail = bigHead;
        while (cur != null) {
            if (cur.val < val) {
                if (smallHead == null) {
                    smallTail = cur;
                    smallHead = smallTail;
                }else {
                    smallTail.next = cur;
                    smallTail = cur;
                }
            }else {
                if (bigHead == null) {
                    bigHead = cur;
                    bigTail = cur;
                }else {
                    bigTail.next = cur;
                    bigTail = cur;
                }
            }
            cur = cur.next;
        }
        if (smallHead == null) {
            return bigHead;
        }
        smallTail.next = bigHead;
            bigTail.next = null;
        return smallHead;
    }

    public Node getMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node reverseList(Node head) {
        Node prev = null;
        Node cur = head;
        while (cur != null) {
            Node next = head.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    public boolean reList(Node head) {

//        if (head.next == null) {
//            return true;
//        }
        Node ohead = head;
        Node temp = getMiddle(ohead);
        Node thead = reverseList(temp);
        while (ohead != null && thead != null) {
            if (ohead.val != thead.val) {
                return false;
            }
            ohead = ohead.next;
            thead = thead.next;
        }
        return true;
    }

    public int Size(Node head) {
        int size = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    public Node partition(Node head, int val) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        Node smallHead = null;
        Node smallTail = null;
        Node bigHead = null;
        Node bigTail = null;

        while (cur != null) {
            if (cur.val < val) {
                if (smallHead == null) {
                    smallHead = cur;
                }else {
                    smallTail.next = cur;
                }
                smallTail = cur;
            }else {
                if (bigHead == null) {
                    bigHead = cur;
                }else {
                    bigTail.next = cur;
                }
                bigTail = cur;
            }
            cur = cur.next;
        }
        smallTail.next = bigHead;
        bigTail = null;
        return smallHead;
    }



    public void reorderList(Node head) {
        Node nHead = head;
        Node cur = head;

        int size = size(cur);
        int temp = size / 2;
        if (size % 2 == 1) {
            temp++;
        }
        for (int i = 0; i< temp; i++) {
            cur = cur.next;
        }

        Node prev = null;

        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        while (prev != null) {
            Node nextOne = nHead.next;
            Node nextTwo = prev.next;
            nHead.next = prev;
            if (size % 2 == 1 || prev.next != null) {
                prev.next = nextOne;
            }
            nHead = nextOne;
            prev = nextTwo;
        }
        if (size % 2 == 1) {
            nHead.next = null;
        }
    }

    public int size(Node head) {
        int size = 0;
        Node cur = head;

        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }
}

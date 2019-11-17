public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
    //头插反转链表
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    //尾插反转链表
    public ListNode reverseList()
    //头删
    public ListNode removeFirst(ListNode head) {
        if (head == null) {
            throw new RuntimeException("链表空啦");
        }
        if (head.next == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }
    //头插
    public ListNode addFirst(ListNode listNode, int val) {
        ListNode node = new ListNode(val);
        //如果链表为空,直接将数据赋值就行
        if (listNode == null) {
            listNode = node;
        }else {//如果链表不为空，则需要将第一个索引指向新数据
            node.next = listNode;
            listNode = node;
        }
        return listNode;
    }
    //展示链表的元素
    public void disPlay(ListNode head) {
        ListNode cur = head;
        System.out.print("[");
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) {
                System.out.print(", ");
            }
            cur = cur.next;
        }
        System.out.println("]");
    }
    //删除对应位置的节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = head;
        ListNode newTail = newHead;
        newTail = newTail;
        int size = Size(newTail);
        for (int i = 0; i < size - n - 1; i++) {
            newTail = newTail.next;
        }
        newTail.next = newTail.next.next;
        return newHead;
    }
    //链表旋转
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head;
        int size = Size(newHead);
        if (k % size == 0) {
            return head;
        }
        int pos =size - k % size;
        ListNode midHead = Pos(head, pos);
        PosClear(head, pos - 1);
        ListNode newTail = midHead;
        while (newTail.next != null) {
            newTail = newTail.next;
        }
        newTail.next = head;
        return midHead;
    }
    public ListNode PosClear(ListNode listNode, int pos) {
        ListNode temp = listNode;
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }
        temp.next = null;
        return listNode;
    }
    public ListNode Pos(ListNode listNode, int pos) {
        ListNode temp = listNode;
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public int Size(ListNode listNode) {
        int size = 0;
        ListNode temp = listNode;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

//    public int Size(ListNode head) {
//        int size = 0;
//        ListNode node = head;
//        while (node.next != null) {
//            size++;
//            node = node.next;
//        }
//        return size;
//    }
}

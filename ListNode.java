public class ListNode {
    int val;
    ListNode random;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode copy(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur != null) {
            ListNode node = new ListNode(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = head;
        ListNode newTail = cur.next;
        ListNode newHead = cur.next;
        while (cur != null) {
            if (cur.random != null) {
                newTail.random = cur.random.next;
            }
            cur.next = newTail.next;
            if (newTail.next != null) {
                newTail.next = newTail.next.next;
            }
            cur = cur.next;
            newTail = newTail.next;
        }
        return newHead;
    }

    public void show(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

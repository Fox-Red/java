package demo_thread;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next.next;
            cur.next.next = cur;
            if (prev != null) {
                prev.next = cur.next;
            }
            cur.next = next;
            prev = cur;
            cur = cur.next;
        }
        return newHead;
    }
}

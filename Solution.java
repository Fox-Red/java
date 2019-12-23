
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    ListNode newHead = new ListNode(-1);
    ListNode newTail = newHead;
    ListNode meger(ListNode list1, ListNode list2) {
        if (list1 == null) {
            newTail.next = list2;
            return newTail.next;
        }
        if (list2 == null) {
            newTail.next = list1;
            return newTail.next;
        }
        if (list1.val < list2.val) {
            newTail.next = list1;
            newTail = list1;
            meger(list1.next, list2);
        } else {
            newTail.next = list2;
            newTail = list2;
            meger(list1, list2.next);
        }
        return newHead.next;
    }
    public void show(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

public class Test {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.random = n1;
        n2.next = n3;
        n3.random = n2;
        n3.next = n4;
        ListNode n = n1.copy(n1);
        n1.show(n);
        System.out.println(n1);
        System.out.println(n);
    }
}

public class Test {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list = list.addFirst(list, 2);
        list = list.addFirst(list, 3);
        list = list.addFirst(list, 4);
        list = list.addFirst(list, 5);
        list.disPlay(list);
        ListNode temp = list.rotateRight(list, 2);
        list.disPlay(temp);
        ListNode temp2 = list.removeFirst(temp);
        list.disPlay(temp2);
    }
}

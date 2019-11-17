public class Main {
    public static void main(String[] args) {
        //要调用一个链表，需要先创建
        ListNode list = new ListNode(1);
        list = list.addFirst(list,2);
        list = list.addFirst(list,3);
        list = list.addFirst(list,4);
        list = list.addFirst(list,5);
        list.disPlay(list);
         list.rotateRight(list,2);
        list.disPlay(list);
//        LinkedList list = new LinkedList();
//        list.addLast(1);
//        list.addLast(1);
//        list.addLast(1);
//        list.addLast(1);
//        list.addLast(1);
//        list.addLast(1);
//        list.addLast(1);
//        list.addLast(1);
//        list.disPlay(list.getLinkedNode());
//        list.addLast(1);
////        list.addLast(4);
//        list.addLast(3);
//        list.addIndex(2, 3);
//        list.addIndex(1, 5);
//        list.addLast(5);
//        list.disPlay(list.getLinkedNode());
//        LinkedList list2 = new LinkedList();
//        list2.addLast(1);
////        list.addLast(4);
//        list2.addLast(2);
//        list2.addIndex(2, 3);
//        list.addIndex(1, 5);
//        list2.addLast(4);
//
//        list2.addLast(1);
////        list.addLast(4);
//        list2.addLast(2);
//        list2.addIndex(2, 3);
////        list.addIndex(1, 5);
//        list2.addLast(4);

//        list2.disPlay(list2.getLinkedNode());
//        LinkedList temp = new LinkedList();
//        LinkedNode temp1 = temp.mergeTwoLists(list.head, list2.head);
//        list.disPlay(temp1);
//        LinkedNode temp2 = list.setLink(list2.head,3);
//        list.disPlay(temp2);
//        boolean result = list.LinkTailAndHead(list.head);
//        System.out.println(result);
//        LinkedNode temp2 = temp.deleteDuplication(temp1);
//        list.disPlay(temp2);
//        System.out.println(list.kLinkIs(list.head, 1));
//        System.out.println(list.size(list.head));
//        list.disPlay(list.getLinkedNode());
//        System.out.println(list.midLink(list.head));
//        boolean test = list.contains(3);
//        System.out.println(test);
//        list.removeAllData(5);
//        list.offset(list.head);
//        System.out.println(list.midLink(list.head));
//        list.disPlay(list.getLinkedNode());
    }
}

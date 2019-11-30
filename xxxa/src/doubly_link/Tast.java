package doubly_link;

public class Tast {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);
        list.disPlay();
        list.popBack();
        list.popBack();
        list.popBack();
        list.disPlay();
        list.popBack();
        list.disPlay();
    }
}

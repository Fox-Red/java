public class TestMain {
    public static void main(String[] args) {
        MyLinkedList ml = new MyLinkedList();
        ml.addAtHead(2);
        ml.deleteAtIndex(1);
        ml.addAtIndex(1,1);
        System.out.println(ml.get(1));
        ml.deleteAtIndex(1);
        System.out.println(ml.get(1));
    }
}

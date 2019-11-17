import java.util.Arrays;

public class List {
    public int[] array = new int[10];
    public int size = 0;

    public void pushFront(int element) {
        if (size > 9) {
            System.out.println("越界啦");
            return;
        }
        for (int i = size; i >=1 ; i--) {
            array[i] = array[i - 1];
        }
        array[0] = element;
        size++;
    }

    //尾插
    public void pushBack(int element) {
        if (size > 9) {
            System.out.println("越界啦");
            return;
        }
        array[size] = element;
        size++;
    }
    public void inSert(int element, int index) {
        if (index == 1) {
            this.pushFront(element);
        }
        if (index == size) {
            this.pushBack(element);
        }
        for (int i = size-1; i >= index - 1; i--) {
            array[i+1] = array[i];
        }
        array[index - 1] = element;
        size++;
    }
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }

    public static void main(String[] args) {
        List list = new List();
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);
        list.pushFront(4);
        list.pushFront(5);
        list.pushBack(6);
        System.out.println(list);
        list.inSert(22, 4);
        System.out.println(list);
    }
}

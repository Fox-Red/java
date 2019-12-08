import java.util.Arrays;

public class MyStack {
    private int[] array;
    private int size = 0;
    public MyStack(int n) {
        array = new int[n];
    }

    public int size() {
        return size;
    }

    public boolean push(int element) {
        if (size == array.length) {
            array = Arrays.copyOf(array, 2*size);
        }
        array[size++] = element;
        return true;
    }

    public int pop() {
        return array[--size];
    }

    public int peek() {
        return array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

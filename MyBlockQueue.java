import java.io.PrintWriter;

public class MyBlockQueue {
    private class MyQueue {
        private int[] array = new int[10];
        private int size = 0;
        private int prve = 0;
        private int rear = 0;

        public synchronized void add(int val) {
            while (size == array.length) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            array[rear++] = val;
            rear = rear % array.length;
            size++;
            notifyAll();
        }

        public synchronized int take() {
            while (size == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int n = array[prve++];
            prve = prve % array.length;
            return n;
        }

        public int getSize() {
            return size;
        }
    }
}

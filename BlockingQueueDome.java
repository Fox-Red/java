import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;

public class BlockingQueueDome {
    static BlockingQueue<Integer> queue1 = new ArrayBlockingQueue<>(10);
//    BlockingQueue<String> queue2 = new LinkedBlockingDeque<>();
//    BlockingQueue<String> queue3 = new PriorityBlockingQueue<>();

    private static long fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }


    private static class Customer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    int n = queue1.take();
                    long result = fib(n);
                    System.out.println(n + "    " + result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Customer().start();
        }
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("请输入n");
            int n = input.nextInt();
            try {
                queue1.put(n);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

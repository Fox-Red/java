import java.util.Scanner;

public class WaitandNotify {
    public static Object obj = new Object();
    static int n = 0;
    private static class Athread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000000; i++) {
                n++;
//                System.out.println("A正在扫地");
            }
            try {
                synchronized (obj) {
                    obj.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("A正在擦桌子");
            }
        }
    }

    public static void main(String[] args) {
        Athread athread = new Athread();
        athread.start();
        Scanner input = new Scanner(System.in);
        System.out.println(n);
        System.out.println("随便输入点什么把");
        input.nextLine();
        synchronized (obj) {
            obj.notify();
        }
    }
}

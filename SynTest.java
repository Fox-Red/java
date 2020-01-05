import java.util.Random;

public class SynTest {
    public static int[] array = new int[100_0000];
    static SynTest obj = new SynTest();

    public static void main(String[] args) {
        Random random = new Random(20191215);
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
//            System.out.println("a[" + i + "]=" + cctttpt,array[i]);

        }
        MyThread mt1 = new MyThread(obj, 0, 333333);
        MyThread mt2 = new MyThread(obj, 333334,666666);
        MyThread mt3 = new MyThread(obj,666667, 1000000);
        mt1.start();
        mt2.start();
        mt3.start();
        try {
            mt1.join();
            mt2.join();
            mt3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(array[0] + "," + array[3] + "," + array[107]);
//        System.out.println(array[0] + "," + array[3] + "," + array[107] + "," + array[323] + "," + array[6666] + "," +array[88888]);
    }
    public void method(int begin, int end) {
//        synchronized (obj) {
            while (begin < end) {
//                array[i] = array[i] * 3;
//                i++;s
                System.out.println("before sync tid = " + Thread.currentThread().getId() + " begin = " + begin);
            synchronized (obj) {
                System.out.println("sync begin tid = " + Thread.currentThread().getId() + " begin = " + begin);
                array[begin] = array[begin] * 3;
                begin++;
                System.out.println("sync end tid = " + Thread.currentThread().getId() + " begin = " + begin);
            }
            }
//            for (; i < array.length; i++) {
//                synchronized (obj) {
//                    array[i] = array[i] * 3;
//                    System.out.println(Thread.currentThread().getName() + ":" + n);
//                    n++;
////                    System.out.println(n);
//                }
//            }
    }
}

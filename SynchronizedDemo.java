public class SynchronizedDemo {
    static private int n = 0;
    static class MyThread extends Thread {

        public MyThread () {}
        public MyThread (String name) {
            super(name);
        }
        public void run() {
            for (int i = 0; i < 50000; i++) {
                n++;
            }
        }
    }

//    public static void main (String[] args) throws InterruptedException {
//        MyThread[] myThreads = new MyThread[5];
//        for (int i = 0; i < 5; i++) {
//            MyThread myThread = new MyThread();
//            myThreads[i] = myThread;
//        }
//        for (int i = 0; i < 5; i++) {
//            myThreads[i].start();
//            myThreads[i].join();
//        }
//        System.out.println(n);
//    }

    public static void main (String[] args) throws InterruptedException {
        MyThread[] myThreads = new MyThread[5];
        for (int i = 0; i < 5; i++) {
            MyThread myThread = new MyThread();
            myThread.start();
            myThreads[i] = myThread;
        }
        for (int i = 0; i < 5; i++) {
            myThreads[i].join();
        }
        System.out.println(n);
    }
}


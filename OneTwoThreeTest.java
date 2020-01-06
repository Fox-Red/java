public class OneTwoThreeTest {
    static OneTwoThreeTest one = new OneTwoThreeTest();
    static OneTwoThreeTest two = new OneTwoThreeTest();
    static OneTwoThreeTest three = new OneTwoThreeTest();
    static int i = 0;
    private static class ATestThread extends Thread {

        @Override
        public void run() {
            while (true) {
                if (i == 0) {
                    one.First();
                    i = 1;
                }
                try {
                        wait();
                        notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class BTestThread extends Thread {
        @Override
        public void run() {
            while (true) {
                if (i == 1) {
                    two.Second();
                    i = 2;
                }
                try {
                        notifyAll();
                        wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            }
    }

    private static class CTestThread extends Thread {

        @Override
        public void run() {
            while (true) {
                if (i == 2) {
                    three.Third();
                    i = 0;
                }
                try {
                        notifyAll();
                        wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            }
    }

    public void First() {
        System.out.println("one");
    }

    public void Second() {
        System.out.println("two");
    }

    public void Third() {
        System.out.println("three");
    }

    public static void main(String[] args) {
        ATestThread aTestThread = new ATestThread();
        BTestThread bTestThread = new BTestThread();
        CTestThread cTestThread = new CTestThread();
        aTestThread.start();
        bTestThread.start();
        cTestThread.start();
//        try {
//            aTestThread.join();
//            bTestThread.join();
//            cTestThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}

public class WatchThreadState {

    static class MyThread extends Thread {
        @Override
        public void run() {
            while (!Thread.interrupted()) {
                System.out.println("我还活着");
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println(myThread.getState());
        myThread.start();
        System.out.println(myThread.getState());
        myThread.interrupt();
        while (myThread.isAlive()) {
            System.out.println(myThread.getState());
        }
        System.out.println(myThread.getState());
    }
}

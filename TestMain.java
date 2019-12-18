package demo_thread;

public class TestMain {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.setName("线程1");
        t1.start();
        MyThread t2 = new MyThread();
        t2.setName("线程2");
        t2.start();
    }

}

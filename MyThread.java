public class MyThread extends Thread{

    private SynTest obj;
    private int begin;
    private int end;

    public MyThread(SynTest obj, int begin, int end) {
        this.obj = obj;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始执行了");
        obj.method(begin, end);
//        System.out.println(Thread.currentThread().getName() + "执行到第" + obj.i + "");
    }
}

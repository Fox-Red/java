import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class MyTimer2 {
    private static class MyTimerTask implements Comparable<MyTimerTask> {
        long runAtTime;
        Runnable target;

        public MyTimerTask(long delay, Runnable target) {
            this.runAtTime = System.currentTimeMillis() + delay;
            this.target = target;
        }

        @Override
        public int compareTo(MyTimerTask o) {
            if (runAtTime < o.runAtTime) {
                return -1;
            } else if (runAtTime == o.runAtTime) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    private PriorityBlockingQueue<MyTimerTask> queue = new PriorityBlockingQueue<>();
    Thread worker = new Worker();

    private class Worker extends Thread {
        @Override
        public void run() {
            //MyTimer.this.queue
            while (true) {
                try {
                    MyTimerTask task = queue.take();
                    if (task.runAtTime <= System.currentTimeMillis()) {
                        task.target.run();
                    } else {
                        queue.put(task);
                        synchronized (this) {
                            wait(task.runAtTime - System.currentTimeMillis());
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    MyTimer2() {
        worker.start();
    }

    public void schedule(Runnable target, long delay) {
        MyTimerTask task = new MyTimerTask(delay, target);
        queue.put(task);
        synchronized (this) {
            notify();
        }
    }

    public static void main(String[] args) {
        Runnable target = new Runnable() {
            @Override
            public void run() {
                System.out.println("5 秒后");
            }
        };
        MyTimer timer = new MyTimer();
        timer.schedule( 1000, target);
        timer.schedule( 2000, target);
        timer.schedule( 3000, target);
        timer.schedule( 4000, target);
        timer.schedule( 5000, target);
    }
}

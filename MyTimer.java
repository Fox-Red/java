import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class MyTimer {
    private static class MyTimerTask implements Comparable<MyTimerTask>{
        long waitingTime;
        Runnable target;
        public MyTimerTask(int delay, Runnable target) {
            this.waitingTime = delay + System.currentTimeMillis();
            this.target = target;
        }
        @Override
        public int compareTo(MyTimerTask o) {
            if (waitingTime < o.waitingTime) {
                return -1;
            } else if (waitingTime == o.waitingTime) {
                return 0;
            } else {
                return 1;
            }
        }
    }
    private BlockingQueue<MyTimerTask> queue = new LinkedBlockingDeque<>();
    Worker worker = new Worker();

    private class Worker extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    MyTimerTask mytask = queue.take();
                    if (mytask.waitingTime <= System.currentTimeMillis()) {
                        mytask.target.run();
                    } else {
                        queue.put(mytask);
                        synchronized (this) {
                            wait(mytask.waitingTime - System.currentTimeMillis());
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    MyTimer() {
        worker.start();
    }

    public void schedule(int delay, Runnable task){
        MyTimerTask mytask = new MyTimerTask(delay, task);
        try {
            queue.put(mytask);
            synchronized (this) {
                notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println(5);
            }
        };
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(1000,task);
        myTimer.schedule(2000,task);
        myTimer.schedule(3000,task);
        myTimer.schedule(4000,task);
        myTimer.schedule(5000, task);
    }

}

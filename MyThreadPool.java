import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class MyThreadPool {
    private class Worker extends Thread {
        Runnable target;
         public Worker(Runnable target) {
            this.target = target;
        }
        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    Runnable command = queue.take();
                    command.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private int corePollSize = 10;
    private int currentPoolSize = 0;
    private List<Worker> workerList = new LinkedList<>();
    private BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();

    public void execute(Runnable command) {
        if (currentPoolSize < corePollSize) {
            Worker worker = new Worker(command);
            worker.start();
            workerList.add(worker);
            currentPoolSize++;
        }
        queue.add(command);
    }
    public void shutDown() {
        for (Worker worker : workerList) {
            worker.interrupt();
        }
        for (Worker worker : workerList) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool();
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("吃饭");
            }
        });
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        pool.shutDown();

    }
}

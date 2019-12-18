package ticket;


//这个类需要有一共享的票属性，以供线程抢资源，所以用Runnable更好
// 否则用thread需要在外面创建一个票堆来保证资源共享
public class TicketRunnable implements Runnable {

    //票属性,假设有1000张票
    private int ticket = 1000;

    //为了保证线程的安全，不发生票重复卖出的情况，需要加锁，先创建一个对象来当锁；
    private Object lock = new Object();
    //下面就是买票的操作
    @Override
    public void run() {
        while (ticket > 0) {
            //加锁
            synchronized (lock) {
                //买票
                System.out.println(Thread.currentThread().getName() + ":" + ticket);
                ticket--;
            }
            //为了体现锁的作用，避免cpu运行太快所以每次让线程睡一会
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package ticket;

public class TicketThread extends Thread {

    //法一    静态属性解决数据不同步问题
    //    //票属性,假设有1000张票
//    private static int ticket = 1000;
//
//    //为了保证线程的安全，不发生票重复卖出的情况，需要加锁，先创建一个对象来当锁；
//    private static Object lock = new Object();
//    //下面就是买票的操作
//    @Override
//    public void run() {
//        while (ticket > 0) {
//            //加锁
//            synchronized (lock) {
//                //买票
//                System.out.println(Thread.currentThread().getName() + ":" + ticket);
//                ticket--;
//            }
//            //为了体现锁的作用，避免cpu运行太快所以每次让线程睡一会
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    //法二    外面传进来票的数据
    //所以下面要锁住的是ticket票库
    private Ticket ticket;

    public TicketThread(Ticket ticket) {
        this.ticket = ticket;
    }
    //下面就是买票的操作
    @Override
    public void run() {
        while (ticket.getCount() > 0) {
            //加锁
            synchronized (ticket) {
                //买票
                System.out.println(Thread.currentThread().getName() + ": 起始站为" + ticket.getStart() +
                        "终点站为" + ticket.getDestination() + "的第" + ticket.getCount() + "张票");
                ticket.setCount(ticket.getCount() - 1);
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

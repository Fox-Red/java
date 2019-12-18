package ticket;

public class Test {
    public static void main(String[] args) {
//        TicketRunnable t = new TicketRunnable();
//        Thread t1 = new Thread(t,"线程1");
//        Thread t2 = new Thread(t,"线程2");
//        Thread t3 = new Thread(t,"线程3");
//        Thread t4 = new Thread(t,"线程4");
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();

//        TicketThread t1 = new TicketThread();
//        t1.start();
//        TicketThread t2 = new TicketThread();
//        t2.start();
//        TicketThread t3 = new TicketThread();
//        t3.start();
//        TicketThread t4 = new TicketThread();
//        t4.start();

        Ticket ticket = new Ticket(1000, "2019.12.8  22:11", "北京","上海");
        TicketThread t1 = new TicketThread(ticket);
        t1.start();
        TicketThread t2 = new TicketThread(ticket);
        t2.start();
        TicketThread t3 = new TicketThread(ticket);
        t3.start();
        TicketThread t4 = new TicketThread(ticket);
        t4.start();
    }
}

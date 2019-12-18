package ticket;

public class Ticket {
    private int count;
    private String time;
    private String start;
    private String destination;

    public Ticket(int count, String time, String start,String destination) {
        this.count = count;
        this.destination = destination;
        this.start = start;
        this.time = time;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public String getTime() {
        return time;
    }
    public String getStart() {
        return start;
    }
    public String getDestination() {
        return destination;
    }
}

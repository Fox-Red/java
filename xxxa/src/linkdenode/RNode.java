package linkdenode;

public class RNode {
    int val;
    RNode next;
    RNode random;

    public RNode(int val, RNode next) {
        this.val = val;
        this.next = next;
    }
    public RNode(int val) {
        this(val, null);
    }

    public RNode copyof(RNode head) {
        return null;
    }
}

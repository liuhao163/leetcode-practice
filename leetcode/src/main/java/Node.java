/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2018/12/23
 */
public class Node {
    private Integer val = 0;

    public Node next;

    public Node() {
        val=-1;
    }

    public Node(Integer val) {
        this.val = val;
    }

    public Integer getVal() {
        return val;
    }

    public Node getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

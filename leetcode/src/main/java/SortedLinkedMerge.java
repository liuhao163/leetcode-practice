/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2018/12/23
 */
public class SortedLinkedMerge {
    static Node a = new Node();

    static Node b = new Node();

    static {
        initA();
        initB();

        System.out.println(a);
        System.out.println(b);
    }

    public static Node merge(Node a,Node b) {
        Node tmp = new Node();
        Node returnNode = tmp;

        Node tmpA = a.next;
        Node tmpB = b.next;
        while (tmpA.getVal() >= 0 || tmpB.getVal() >= 0) {
            if (tmpA.getVal() >= tmpB.getVal()) {
                tmp.next = new Node(tmpA.getVal());
                tmpA = tmpA.next;
            } else {
                tmp.next = new Node(tmpB.getVal());
                tmpB = tmpB.next;
            }
            tmp = tmp.next;
        }

        return returnNode;
    }

    public static void main(String[] args) {
        System.out.println(merge(a,b));
    }

    public static void initA() {
        Node a1 = new Node(10);
        a.next = a1;
        Node a2 = new Node(8);
        a1.next = a2;
        Node a3 = new Node(6);
        a2.next = a3;
        Node a4 = new Node(2);
        a3.next = a4;
        Node a5 = new Node(0);
        a4.next = a5;
        a5.next = new Node();
    }


    public static void initB() {
        Node b1 = new Node(9);
        b.next = b1;
        Node b2 = new Node(8);
        b1.next = b2;
        Node b3 = new Node(5);
        b2.next = b3;
        Node b4 = new Node(4);
        b3.next = b4;
        Node b5 = new Node(3);
        b4.next = b5;
        b5.next = new Node();
    }
}

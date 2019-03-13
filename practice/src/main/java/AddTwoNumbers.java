/**
 * @Author: liuhaoeric Create time: 2018/09/20 Description:
 */
public class AddTwoNumbers {

    static ListNode a = new ListNode(2);
    static ListNode b = new ListNode(5);

    static {
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);
    }

    public ListNode addTwoNumbers(ListNode a, ListNode b) {

        ListNode tmpA = a;
        ListNode tmpB = b;

        Integer carry = 0;//是否进位

        ListNode dummyfalg = new ListNode(0);//todo 设定一个flag
        ListNode tempReturnNode = dummyfalg;//todo 然后用中间变量开始往结果链表中插入值、

        while (tmpA != null || tmpB != null) {
            Integer aVal = 0;
            if (tmpA != null) {
                aVal = tmpA.val;
                tmpA = tmpA.next;
            }
            Integer bVal = 0;
            if (tmpB != null) {
                bVal = tmpB.val;
                tmpB = tmpB.next;
            }

            int res = aVal + bVal + carry;

            carry = res / 10;
            tempReturnNode.next = new ListNode(res % 10);
            tempReturnNode = tempReturnNode.next;
        }

        if (carry > 0) {
            tempReturnNode.next = new ListNode(carry);
        }

        return dummyfalg.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new AddTwoNumbers().addTwoNumbers(a, b);

        ListNode n = listNode;
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }


}

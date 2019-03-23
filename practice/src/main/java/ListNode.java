/**
 * @Author: liuhaoeric Create time: 2018/09/20 Description:
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" + "val=" + val + ", next=" + next + '}';
    }

    public static void main(String args[]) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(node);

        // 反转链表1
        // ListNode cur = (ListNode) node;
        // ListNode prev = null;
        // ListNode res = null;
        // while (cur != null) {
        // ListNode nextNode = cur.next;
        // cur.next = prev;
        // prev = cur;
        // if (nextNode == null) {
        // res = cur;
        // }
        // cur = nextNode;
        // }
        // System.out.println(res);

        // 反转链表2
        ListNode cur = node;
        ListNode res = null;
        while (cur != null) {
            ListNode newNode = new ListNode(cur.val);
            cur = cur.next;
            
            newNode.next = res;
            res = newNode;
            
        }

        System.out.println(res);
    }
}

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

        // 反转方法1
//        ListNode cur = node;
//        ListNode prev = null;
//        ListNode ret = null;
//
//        while (cur != null) {
//            ListNode nextNode = cur.next;
//            cur.next = prev;
//            prev = cur;
//            if (nextNode == null) {
//                ret = cur;
//            }
//            cur = nextNode;
//        }
//
//        System.out.println(ret);

        ListNode cur2 = node;
        ListNode ret = null;
        while (cur2 != null) {
            ListNode newNode = new ListNode(cur2.val);

            newNode.next = ret;
            ret = newNode;

            cur2 = cur2.next;
        }


        System.out.println(ret);
    }


}

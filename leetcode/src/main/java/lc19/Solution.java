package lc19;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2020/6/27
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> l = new ArrayList<>();

        ListNode cur = head;
        while (cur != null) {
            l.add(cur);
            cur = cur.next;
        }

        //删头结点
        if (l.size() - n == 0) {
            return head.next;
        }

        if (l.size() - n < 0) {
            return null;
        }
        ListNode removeNode = l.get(l.size() - n - 1);
        if (removeNode.next == null) {
            return head;
        }
        removeNode.next = removeNode.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
//        ListNode l3=new ListNode(3);
//        ListNode l4=new ListNode(4);
//        ListNode l5=new ListNode(5);
        l1.next = l2;
//        l2.next=l3;
//        l3.next=l4;
//        l4.next=l5;

        ListNode r=new Solution().removeNthFromEnd(l1, 2);
        System.out.println(r);
    }
}

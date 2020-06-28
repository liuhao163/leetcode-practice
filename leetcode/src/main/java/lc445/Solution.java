package lc445;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2020/6/27
 */
public class Solution {

    public static void main(String[] args) {
        ListNode l17=new ListNode(1);
//        ListNode l12=new ListNode(2);
//        ListNode l14=new ListNode(4);
//        ListNode l13=new ListNode(3);
//        l17.next=l12;
//        l12.next=l14;
//        l14.next=l13;

        ListNode l25=new ListNode(9);
        ListNode l26=new ListNode(9);
//        ListNode l24=new ListNode(4);
        l25.next=l26;
//        l26.next=l24;
        ListNode ret=new Solution().addTwoNumbers(l17,l25);
        System.out.println(ret);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<ListNode> s1 = new LinkedList<>();
        LinkedList<ListNode> s2 = new LinkedList<>();

        ListNode c1 = l1;
        ListNode c2 = l2;
        while (c1 != null && c2 != null) {
            s1.addFirst(c1);
            s2.addFirst(c2);
            c1 = c1.next;
            c2 = c2.next;
        }
        while (c1 != null) {
            s1.addFirst(c1);
            c1 = c1.next;
        }
        while (c2 != null) {
            s2.addFirst(c2);
            c2 = c2.next;
        }

        ListNode head = new ListNode(-1);

        int s = 0;
        while (s1.size() > 0 && s2.size() > 0) {
            ListNode n1 = s1.removeFirst();
            ListNode n2 = s2.removeFirst();
            int v = n1.val + n2.val + s;
            s = v / 10;
            ListNode n = new ListNode(v % 10);
            ListNode cur = head.next;
            head.next = n;
            n.next = cur;
        }

        while (s1.size()>0){
            ListNode n = s1.removeFirst();
            int v = n.val+s;
            s = v / 10;
            ListNode cur = head.next;
            head.next = new ListNode(v%10);
            head.next.next = cur;
        }

        while (s2.size()>0){
            ListNode n = s2.removeFirst();
            int v = n.val+s;
            s = v / 10;
            ListNode cur = head.next;
            head.next = new ListNode(v%10);
            head.next.next = cur;
        }

        if(s>0){
            ListNode cur = head.next;
            head.next = new ListNode(s);
            head.next.next = cur;
        }

        return head.next;
    }
}

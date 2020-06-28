package lc1290;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2020/6/27
 */
public class Solution {

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(0);
        ListNode l3=new ListNode(1);
        l1.next=l2;
        l2.next=l3;
//        1->0->1
        System.out.println(new Solution().getDecimalValue(l1));
    }

    public int getDecimalValue(ListNode head) {
        ListNode cur = head;
        List<Integer> list = new ArrayList<>();
        int ret = 0;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        for (int i = 0; i < list.size(); i++) {
            ret += list.get(i) << (list.size() - i-1);
        }

        return ret;
    }


}

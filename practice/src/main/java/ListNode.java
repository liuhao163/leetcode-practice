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
        ListNode cur=node;
        ListNode ret=null;
        ListNode prev=null;
        while(cur!=null){
            ListNode nextNode=cur.next;
            cur.next=prev;
            prev=cur;
            if(nextNode==null){
                ret=cur;
            }

            cur=nextNode;
        }

        System.out.println(ret);

//        //反转方法2
//        ListNode ret2=null;
//        ListNode cur2=node;
//        while(cur2!=null){
//            //创建新的节点
//            ListNode newNode=new ListNode(cur2.val);
//
//            //建立新关系.把这个新节点保存起来作为下一个节点的next
//            newNode.next = ret2;
//            ret2=newNode;
//
//            cur2=cur2.next;
//        }
//        System.out.println(ret2);
    }
}

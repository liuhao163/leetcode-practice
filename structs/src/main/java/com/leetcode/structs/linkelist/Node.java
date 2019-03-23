package com.leetcode.structs.linkelist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: liuhaoeric
 * Create time: 2019/03/23
 * Description:
 */
public class Node {
    private Integer val;
    public Node next;
    public Node prev;

    public Node(Integer val) {
        this.val = val;
    }

    public Integer getVal() {
        return val;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    @Override
    public String toString() {
        return "Node{" +
                "node=" + val +
                ", next=" + next +
                '}';
    }

    /**
     * 找中间节点
     *
     * @param node
     * @return
     */
    public static Node findMid(Node node) {
        if (node == null || node.next == null || node.next.next == null) {
            return node;
        }

        Node slow = node;
        Node fast = node;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * 可用快慢指针找是否有环
     *
     * @param node
     * @return
     */
    public static boolean checkNodeLoop(Node node) {
        if (node == null || node.next == null) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        Node cur = node;

        while (cur != null) {
            if (set.contains(cur.val)) {
                return true;
            }
            set.add(cur.val);
            cur = cur.next;
        }

        return false;
    }

    /**
     * 有序俩表合并
     *
     * @param a
     * @param b
     * @return
     */
    public static Node merge(Node a, Node b) {
        Node head = new Node(null);
        Node ret = head;

        Node cura = a;
        Node curb = b;
        while (cura != null && curb != null) {
            if (cura.val < curb.val) {
                ret.next = cura;
                cura = cura.next;
            } else {
                ret.next = curb;
                curb = curb.next;
            }
            ret = ret.next;
        }

        if (cura != null) {
            ret.next = cura;
        }
        if (curb != null) {
            ret.next = curb;
        }
        return head.next;
    }

    /**
     * 删除倒数第几个节点
     *
     * @return
     */
    public static Node removeNodeByDescPosition(Node a, int position) {
        if (a == null) {
            return null;
        }
        List<Node> list = new ArrayList<>();

        Node head = new Node(null);
        head.next = a;
        Node tmp = head;
        while (tmp != null) {
            list.add(tmp);
            tmp = tmp.next;
        }
        //超过限制
        if (position >= list.size()) {
            return head.next;
        }

        //找到要删的节点的前置节点
        Node n;
        int nodeidx = list.size() - position;
        n = list.get(nodeidx - 1);
        n.next = n.next.next;
        return head.next;
    }

    public static Node reverseNode(Node node) {
        return null;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

//        System.out.println(Node.findMid(a));
//
//        System.out.println(Node.checkNodeLoop(a));
//
//
//        Node a1 = new Node(0);
//        Node b1 = new Node(2);
//        Node c1 = new Node(4);
//        Node d1 = new Node(6);
//        Node e1 = new Node(8);
//        Node f1 = new Node(10);
//        Node g1 = new Node(11);
//        a1.next = b1;
//        b1.next = c1;
//        c1.next = d1;
//        d1.next = e1;
//        e1.next = f1;
//        f1.next = g1;
//
//        System.out.println(Node.merge(a, a1));

        System.out.println(Node.removeNodeByDescPosition(new Node(10), 1));
    }
}


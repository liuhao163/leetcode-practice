package com.leetcode.structs.linked;

import java.util.HashSet;
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
     * 可用快慢指针
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

    public static Node mergeSortedNode(Node a, Node b) {
        Node curA = a;
        Node curB = b;

        Node ret = new Node(null);
        Node head = ret;
        while (curA != null && curB != null) {
            Node next = ret;

            if (curA.val < curB.val) {
                next.next = new Node(curA.val);
                next.next.next = new Node(curB.val);
            } else {
                next.next = new Node(curB.val);
                next.next.next = new Node(curA.val);
            }

            curA = curA.next;
            curB = curB.next;
            ret = next.next.next;
            System.out.println(ret);
            System.out.println(next);

        }
        System.out.println("======");
        System.out.println(head);
        System.out.println(ret);
        if (curA != null) {
            ret.next = curA;
        }
        if (curB != null) {
            ret.next = curB;
        }

        return head.next;
    }

    public static Node merge(Node a, Node b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }

        Node head = new Node(null);
        Node ret = head;

        Node curA = a;
        Node curB = b;
        while (curA != null && curB != null) {
            if (curA.val < curB.val) {
                ret.next = curA;
                curA = curA.next;
            } else {
                ret.next = curB;
                curB = curB.next;
            }
            ret = ret.next;
        }

        if (curA != null) {
            ret.next = curA;
        }
        if (curB != null) {
            ret.next = curB;
        }


        return head.next;
    }


    public static Node reverseNode(Node node) {
        return null;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(3);
        Node c = new Node(5);
        Node d = new Node(7);
        Node e = new Node(9);
        Node f = new Node(10);
        Node g = new Node(14);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        System.out.println(Node.findMid(a));

        System.out.println(Node.checkNodeLoop(a));


        Node a1 = new Node(0);
        Node b1 = new Node(2);
        Node c1 = new Node(4);
        Node d1 = new Node(6);
        Node e1 = new Node(8);
        Node f1 = new Node(10);
        Node g1 = new Node(11);
        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        d1.next = e1;
        e1.next = f1;
        f1.next = g1;

        System.out.println(Node.merge(a, a1));
    }
}


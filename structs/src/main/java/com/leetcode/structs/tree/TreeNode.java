package com.leetcode.structs.tree;

/**
 * @Author: liuhaoeric
 * Create time: 2019/06/24
 * Description:
 */
public class TreeNode {

    private int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                "}";
    }

    public static void InsertNode(TreeNode treeNode, int v) {
        TreeNode n = treeNode;
        if (n == null) {
            treeNode = new TreeNode(v);
            return;
        }

//        if (n.value == v) {
//            throw new IllegalArgumentException("value duplicate v=" + v);
//        } else if (v < n.value) {
//            if(n.left==null){
//                n.left = new TreeNode(v);
//                return;
//            }
//            InsertNode(n.left, v);
//        } else if (v > n.value) {
//            if(n.right==null){
//                n.right = new TreeNode(v);
//                return;
//            }
//            InsertNode(n.right, v);
//        }

        while (n != null) {
            if (v < n.value) {
                if (n.left == null) {
                    n.left = new TreeNode(v);
                    return;
                }
                n = n.left;
            } else if (v > n.value) {
                if (n.right == null) {
                    n.right = new TreeNode(v);
                    return;
                }
                n = n.right;
            } else {
                throw new IllegalArgumentException("value duplicate v=" + v);
            }
        }
    }


    public static TreeNode findNodeByValue(TreeNode tree, int value) {
        TreeNode p = tree;

        if (p.value == value) {
            return p;
        }

        if (value < p.value && p.left!=null) {
          return   findNodeByValue(p.left, value);
        }

        if(value>p.value && p.right!=null){
          return   findNodeByValue(p.right, value);
        }

//        while (p != null) {
//            if (p.value == value) {
//                return p;
//            }
//            if (value > p.value) {
//                if (p.right != null) {
//                    p = p.right;
//                } else {
//                    return null;
//                }
//            } else {
////                value<p.value
//                if (p.left != null) {
//                    p = p.left;
//                } else {
//                    return null;
//                }
//            }
//        }

        return null;

    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(33);
        InsertNode(t, 16);
        InsertNode(t.left, 13);
        InsertNode(t.left.left, 15);
        InsertNode(t.left, 18);
        InsertNode(t.left.right, 17);
        InsertNode(t.left.right, 25);
        InsertNode(t.left.right.right, 19);
        InsertNode(t.left.right.right, 27);
        InsertNode(t, 50);
        InsertNode(t.right, 34);
        InsertNode(t.right, 58);
        InsertNode(t.right.right, 51);
        InsertNode(t.right.right, 66);
        InsertNode(t.right.right.left, 55);

        System.out.println(t);
        System.out.println("find=======");
        System.out.println(findNodeByValue(t, 58));
    }
}
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

    public static void insertNode(TreeNode treeNode, int v) {
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
//            insertNode(n.left, v);
//        } else if (v > n.value) {
//            if(n.right==null){
//                n.right = new TreeNode(v);
//                return;
//            }
//            insertNode(n.right, v);
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

        if (value < p.value && p.left != null) {
            return findNodeByValue(p.left, value);
        }

        if (value > p.value && p.right != null) {
            return findNodeByValue(p.right, value);
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

    public static TreeNode delNode(TreeNode tree, int v) {
        if (tree == null)
            return null;

        TreeNode parent = null;
        TreeNode node = tree;

        while (node != null) {
            if (v < node.value) {
                parent = node;
                node = node.left;
            } else if (v > node.value) {
                parent = node;
                node = node.right;
            } else {
                break;
            }
        }

        if (node == null) {
            return tree;
        }

        //如果俩个子树都存在，
        // 找第一个比他大的数（右子树的左子树叶子节点）
        // 将这个待删除节点替换成叶子节点，然后删除这个叶子节点
        while (node.left != null && node.right != null) {
            TreeNode rightMin = node.right;
            TreeNode rightMinParent = node;
            while (rightMin.left != null) {
                rightMinParent = rightMin;
                rightMin = rightMin.left;
            }

            node.value = rightMin.value;
            parent = rightMinParent;
            node = rightMin;
        }

        TreeNode child = null;
        if (node.left != null) {
            child = node.left;
        } else if (node.right != null) {
            child = node.right;
        }

        if (parent == null) {
            tree = child;
            return tree;
        }

        if(node.value<parent.value){
            parent.left=child;
        }else{
            parent.right=child;
        }

        return tree;

    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(33);
        insertNode(t, 16);
        insertNode(t.left, 13);
        insertNode(t.left.left, 15);
        insertNode(t.left, 18);
        insertNode(t.left.right, 17);
        insertNode(t.left.right, 25);
        insertNode(t.left.right.right, 19);
        insertNode(t.left.right.right, 27);
        insertNode(t, 50);
        insertNode(t.right, 34);
        insertNode(t.right, 58);
        insertNode(t.right.right, 51);
        insertNode(t.right.right, 66);
        insertNode(t.right.right.left, 55);

        System.out.println(t);
        System.out.println("find=======");
        System.out.println(findNodeByValue(t, 58));

        System.out.println("del=======");
        t=delNode(t, 18);
        System.out.println(t);
    }
}

package com.leetcode.structs.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//        TreeNode p = treeNode;
//        while (p != null) {
//            if (v<p.value) {
//                if (p.left == null) {
//                    p.left = new TreeNode(v);
//                    return;
//                }
//
//                p = p.left;
//            } else {
//                //
//                if (p.right == null) {
//                    p.right = new TreeNode(v);
//                    return;
//                }
//
//                p = p.right;
//            }
//        }
        TreeNode p = treeNode;
        if (v < p.value) {
            if (p.left == null) {
                p.left = new TreeNode(v);
                return;
            }
            insertNode(p.left, v);
        } else if (v >= p.value) {
            if (p.right == null) {
                p.right = new TreeNode(v);
                return;
            }
            insertNode(p.right, v);
        }
    }


    public static List<TreeNode> find(TreeNode tree, int value) {
        TreeNode p = tree;

//        if (p.value == value) {
//            return p;
//        }

        List<TreeNode> treeNodes = new ArrayList<>();
//        if (value < p.value && p.left != null) {
//            findNodeByValue(p.left, value, treeNodes);
//        }
//
//        if (value >= p.value && p.right != null) {
//            findNodeByValue(p.right, value, treeNodes);
//        }

        while (p != null) {
            if (value >= p.value) {
                if (p.value == value) {
                    treeNodes.add(p);
                }
                p = p.right;
            } else {
                p = p.left;
            }
        }

        return treeNodes;
    }

    private static void findNodeByValue(TreeNode tree, int value, List<TreeNode> treeNodes) {
        if (tree == null) {
            return;
        }

        if (value < tree.value) {
            findNodeByValue(tree.left, value, treeNodes);
        }

        if (value >= tree.value) {
            if (value == tree.value) {
                treeNodes.add(tree);
            }
            findNodeByValue(tree.right, value, treeNodes);
        }
    }


    public static TreeNode findMinNode(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }

        TreeNode ret = treeNode;

        while (ret != null) {
            if (ret.left == null) {
                break;
            }
            ret = ret.left;
        }

        return ret;
    }

    public static TreeNode findMaxNode(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }

        TreeNode ret = treeNode;

        while (ret.right != null) {
            ret = ret.right;
        }

        return ret;
    }

    public static TreeNode delNode(TreeNode tree, int v) {
        //遍历树，找到相等节点放在eqNodes父节点放在pNodes
        TreeNode node = tree;
        List<TreeNode> eqNodes = new ArrayList<>();
        List<TreeNode> pNodes = new ArrayList<>();
        while (node != null) {
            if (v < node.value) {
                if (node.left!=null && node.left.value == v) {
                    eqNodes.add(node.left);
                    pNodes.add(node);
                }

                node = node.left;
            } else {
                if (node.right!=null && node.right.value == v) {
                    eqNodes.add(node.right);
                    pNodes.add(node);
                }
                node = node.right;
            }
        }

        //没有相等的
        if (eqNodes.size() == 0) {
            return tree;
        }

        //后续遍历相等的节点一次删除
        for (int i = eqNodes.size() - 1; i >= 0; i--) {
            node = eqNodes.get(i);
            TreeNode parent = pNodes.get(i);

            //同时有左右子树，找到右子树里最小的节点和父节点，将右子树最小的节点的值复制给之前要删除的节点
            while (node.left != null && node.right != null) {
                TreeNode minNode = node.right;
                TreeNode minPNode = node;
                while (minNode.left != null) {
                    minPNode = minNode;
                    minNode = minPNode.left;
                }

                //复制
                node.value = minNode.value;
                //删除右子树最小的节点
                node = minNode;
                parent = minPNode;
            }

            //找到child树，不会出现左右子树同时存在的情况：P
            TreeNode child = null;
            if (node.left != null) {
                child = node.left;
            } else if (node.right != null) {
                child = node.right;
            }

            //开始删除如果parent是空，删的是根节点，如果node<parent删除的是左子树，反之是右子树
            if (parent == null) {
                tree = child;
            } else if (node.value < parent.value) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        return tree;

    }


    public static void frontForeach(TreeNode node) {
        if (node != null) {
            System.out.println(node.value);
            frontForeach(node.left);
            frontForeach(node.right);
        }
    }

    public static void midForeach(TreeNode node) {
        if (node != null) {
            midForeach(node.left);
            System.out.println(node.value);
            midForeach(node.right);
        }
    }

    public static void backForeach(TreeNode node) {
        if (node != null) {
            backForeach(node.left);
            backForeach(node.right);
            System.out.println(node.value);
        }
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
        insertNode(t.right.right.right, 66);

        System.out.println(t);
        System.out.println("find=======");
        System.out.println(find(t, 66));
        System.out.println();
        System.out.println("frontForeach=======");
        frontForeach(t);
        System.out.println("midForeach=======");
        midForeach(t);
        System.out.println("backForeach=======");
        backForeach(t);
//
        System.out.println("del=======");
        t = delNode(t, 18);
        System.out.println(t);

        System.out.println("find min=======");
        System.out.println(findMinNode(t));

        System.out.println("find max=======");
        System.out.println(findMaxNode(t));

        /////////////////
        t = new TreeNode(13);
        insertNode(t, 8);
        insertNode(t.left, 6);
        insertNode(t.left, 10);
        insertNode(t, 18);
        insertNode(t.right, 16);
        insertNode(t.right, 20);
        insertNode(t.right.right, 18);
        insertNode(t.right.right.left, 19);
        System.out.println(t);
        System.out.println("del=======");
        t = delNode(t, 18);
        System.out.println(t);


    }
}

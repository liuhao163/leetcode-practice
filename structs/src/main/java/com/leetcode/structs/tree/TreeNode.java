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
        TreeNode n = treeNode;
        if (n == null) {
            treeNode = new TreeNode(v);
            return;
        }

//         if (v < n.value) {
//            if(n.left==null){
//                n.left = new TreeNode(v);
//                return;
//            }
//            insertNode(n.left, v);
//        } else if (v >= n.value) {
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
                    break;
                }
                n = n.left;
            } else if (v >= n.value) {
                //如果相等和大于一样处理往右边节点插入
                if (n.right == null) {
                    n.right = new TreeNode(v);
                    break;
                }
                n = n.right;
            }
        }
    }


    public static List<TreeNode> find(TreeNode tree, int value) {
        TreeNode p = tree;

//        if (p.value == value) {
//            return p;
//        }

        List<TreeNode> treeNodes = new ArrayList<>();
        if (value < p.value && p.left != null) {
            findNodeByValue(p.left, value, treeNodes);
        }

        if (value >= p.value && p.right != null) {
            findNodeByValue(p.right, value, treeNodes);
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
        if (tree == null)
            return null;

        TreeNode p = null;
        TreeNode n = tree;

        List<TreeNode> eqNodes = new ArrayList<>();
        List<TreeNode> pNodes = new ArrayList<>();

        while (n != null) {
            if (v < n.value) {
                p = n;
                n = n.left;
                if (n != null && n.value == v) {
                    eqNodes.add(n);
                    pNodes.add(p);
                }
            } else if (v >= n.value) {
                p = n;
                n = n.right;

                if (n != null && n.value == v) {
                    eqNodes.add(n);
                    pNodes.add(p);
                }
            }
        }

        if (eqNodes.size() == 0) {
            return tree;
        }

        for (int i = eqNodes.size() - 1; i >= 0; i--) {
            TreeNode node = eqNodes.get(i);
            TreeNode parent = pNodes.get(i);

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

            if (node.value < parent.value) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        return tree;

    }


    public static void midForeach(TreeNode node) {
        if(node!=null){
            midForeach(node.left);
            System.out.println(node.value);
            midForeach(node.right);
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
        System.out.println("midForeach=======");
        midForeach(t);
//
//        System.out.println("del=======");
//        t = delNode(t, 18);
//        System.out.println(t);

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

package com.algorithm.剑指offer;

/**
 * @ClassName JZ68_1
 * @Description TODO
 * @Author bill
 * @Date 2021/9/18 14:32
 * @Version 1.0
 **/
/*
    二叉搜索树的最近公共祖先

    注意是 二叉搜索树 已有序
 */
public class JZ68_1 {

    //法1、迭代遍历
    //分在左子树和右子树的情况遍历
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val) {       // p ，q 在右子树
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {   // p ，q 在左子树
                root = root.left;
            } else {
                break;       // p ，q 在两边
            }
        }
        return root;
    }

    //法1、迭代遍历-优化
    //提前保证  p.val < q.val  减少后续判断条件
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //保证 p.val <= q.val
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        while (root != null) {
            if (root.val < p.val) {       // p ，q 在右子树
                root = root.right;
            } else if (root.val > q.val) {   // p ，q 在左子树
                root = root.left;
            } else {
                break;       // p ，q 在两边
            }
        }
        return root;
    }

    //法2、递归
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {       // p ，q 在右子树  递归 右子树
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {   // p ，q 在左子树  递归 左子树
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

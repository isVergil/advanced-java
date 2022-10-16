package com.algorithm.剑指offer;

/**
 * @ClassName JZ68_2
 * @Description TODO
 * @Author bill
 * @Date 2021/9/18 14:52
 * @Version 1.0
 **/
/*
字节实习

JZ86 在二叉树中找到两个节点的最近公共祖先

 二叉树的最近公共祖先

 注意是 普通二叉树
 最近公共祖先定义：
     设节点 root 为节点 p, q 的某公共祖先，
     若其左子节点 root.left 和右子节点 root.right 都不是 p,q 的公共祖先，
     则称 rootr是 “最近的公共祖先” 。
 三种情况：
 1、p、q 分列异侧
 2、p = root ,q 为其子树
 3、q = root ,p 为其子树
 */
public class JZ68_2 {

    //递归
    //1、终止条件 递归碰到p 或者 q 或者两者都没碰到 返回
    //2、DFS 遍历节点
    //3、返回结果，
    //---若树里面只存在p，或只存在q，则返回存在的那一个（已存在 p，q 都为 null 的情况），
    //---否则（都存在）返回 root
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //1、树空 返回 null
        if (root == null) {
            return null;
        }
        //2、有root = p || root = q
        if (root == p || root == q) {
            return root;
        }
        //3、递归遍历左右子树
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    //递归 简洁写法（只作参考）
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
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

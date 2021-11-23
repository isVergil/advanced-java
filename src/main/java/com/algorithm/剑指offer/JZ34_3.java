package com.algorithm.剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName JZ34_3
 * @Description TODO
 * @Author bill
 * @Date 2021/11/8 16:20
 * @Version 1.0
 **/
/*
JZ84 二叉树中和为某一值的路径(三)
https://www.nowcoder.com/practice/965fef32cae14a17a8e86c76ffe3131f?tpId=13&tqId=2277604&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class JZ34_3 {
    int res = 0;

    //遍历每个节点并递归计算路径值是否是 0
    //遍历节点可用 队列 或者 递归
    //下面是队列
    public int FindPath(TreeNode root, int sum) {
        // write code here
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> trees = new LinkedList<>();
        trees.offer(root);
        while (!trees.isEmpty()) {
            TreeNode node = trees.poll();
            if (node.left != null) {
                trees.offer(node.left);
            }
            if (node.right != null) {
                trees.offer(node.right);
            }
            calPath(node, sum);
        }
        return res;

    }

    //下面是递归
    public int FindPath1(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        calPath(root, sum);
        FindPath1(root.left, sum);
        FindPath1(root.right, sum);
        return res;

    }

    void calPath(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (sum == root.val) {
            res++;
        }
        calPath(root.left, sum - root.val);
        calPath(root.right, sum - root.val);
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

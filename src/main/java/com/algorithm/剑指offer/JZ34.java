package com.algorithm.剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName JZ34
 * @Description TODO
 * @Author bill
 * @Date 2021/9/3 9:46
 * @Version 1.0
 **/
/*
二叉树中和为某一值的路径

输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。



 */
public class JZ34 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        JZ34 tmp = new JZ34();
        tmp.FindPath(root, 1);
        System.out.println(tmp.res1);
    }

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    void recur(TreeNode root, int tar) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        tar -= root.val;
        //路径相等 +  根节点
        if (tar == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList(path));
        }
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();
    }

    ArrayList<ArrayList<Integer>> res1 = new ArrayList();

    ArrayList<Integer> tmp = new ArrayList();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
        if (root == null) {
            return res1;
        }
        backtrack(root, expectNumber);
        return res1;
    }

    void backtrack(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        tmp.add(root.val);
        val -= root.val;
        if (val == 0 && root.left == null && root.right == null) {
            res1.add(new ArrayList(tmp));
            //return;
        }
        backtrack(root.left, val);
        backtrack(root.right, val);
        if (tmp.size() > 0) {
            tmp.remove(tmp.size() - 1);
        }
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

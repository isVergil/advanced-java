package com.internship.bytedance;

import java.util.*;

/**
 * @ClassName LCOF_32_3
 * @Description TODO
 * @Author bill
 * @Date 2021/9/6 15:41
 * @Version 1.0
 **/
public class LCOF_32_3 {
    //leetcode版本
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> trees = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        trees.offer(root);
        while (!trees.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = trees.size(); i > 0; i--) {
                TreeNode node = trees.poll();
                if (res.size() % 2 == 0) {
                    temp.addLast(node.val);
                } else {
                    temp.addFirst(node.val);
                }
                if (node.left != null) {
                    trees.add(node.left);
                }
                if (node.right != null) {
                    trees.add(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }

    //牛客版本
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> trees = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot != null) {
            trees.offer(pRoot);
        }
        while (!trees.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = trees.size(); i > 0; i--) {
                TreeNode node = trees.poll();
                if (res.size() % 2 == 0) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if (node.left != null) {
                    trees.offer(node.left);
                }
                if (node.right != null) {
                    trees.offer(node.right);
                }
            }
            res.add(new ArrayList(list));
        }
        return res;
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



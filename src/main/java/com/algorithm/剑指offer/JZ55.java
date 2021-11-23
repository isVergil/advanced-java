package com.algorithm.剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName JZ55
 * @Description TODO
 * @Author bill
 * @Date 2021/10/31 14:32
 * @Version 1.0
 **/
/*
二叉树的深度
1、递归
2、层序遍历
 */
public class JZ55 {
    //递归
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

    //层序遍历
    public int TreeDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> queue = new ArrayList<TreeNode>() {{
            add(root);
        }};
        List<TreeNode> temp;
        int res = 0;
        while (!queue.isEmpty()) {
            temp = new ArrayList<>();
            for (TreeNode treeNode : queue) {
                if (treeNode.left != null) {
                    temp.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    temp.add(treeNode.right);
                }
            }
            res++;
            queue = temp;
        }
        return res;
    }

    //层序遍历 优化 LinkedList 有序
    public int TreeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        int res = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- >0){
                TreeNode removedNode = queue.removeFirst();
                if (removedNode.left != null) {
                    queue.add(removedNode.left);
                }
                if (removedNode.right != null) {
                    queue.add(removedNode.right);
                }
            }
            res++;
        }
        return res;
    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}

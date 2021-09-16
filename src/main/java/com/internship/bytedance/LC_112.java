package com.internship.bytedance;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName LC_112
 * @Description TODO
 * @Author bill
 * @Date 2021/9/16 14:42
 * @Version 1.0
 **/
/*
路径总和

给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
叶子节点 是指没有子节点的节点。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_112 {

    //法1  非递归  广度优先搜索
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        //存节点
        Queue<TreeNode> queNode = new LinkedList<>();
        //存存入队列的节点总和
        Queue<Integer> queVal = new LinkedList<>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode nowNode = queNode.poll();
            int temp = queVal.poll();
            if (nowNode.left == null && nowNode.right == null) {
                if (temp == targetSum) {
                    return true;
                }
                //说明该叶子节点不满足条件,节点继续出队,继续比较
                continue;
            }
            if (nowNode.left != null) {
                queNode.offer(nowNode.left);
                queVal.offer(nowNode.left.val + temp);
            }
            if (nowNode.right != null) {
                queNode.offer(nowNode.right);
                queVal.offer(nowNode.right.val + temp);
            }
        }
        return false;
    }

    //法2 递归  类似深度搜索
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum1(root.left, targetSum - root.val) || hasPathSum1(root.right, targetSum - root.val);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

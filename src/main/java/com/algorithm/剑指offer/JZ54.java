package com.algorithm.剑指offer;

/**
 * @ClassName JZ54
 * @Description TODO
 * @Author bill
 * @Date 2021/10/27 16:19
 * @Version 1.0
 **/
public class JZ54 {

    int k, result;

    //二叉搜索树 求第 k 大的节点 即 求中序遍历的倒数第 k 个元素
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return result;
    }

    //中序遍历倒序
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        //求出了第 k 大的那个元素
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            result = root.val;
        }
        dfs(root.left);

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

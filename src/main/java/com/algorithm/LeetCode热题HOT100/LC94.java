package com.algorithm.LeetCode热题HOT100;

import java.util.*;

/**
 * @ClassName LC94
 * @Description 94. 二叉树的中序遍历
 * @Author bill
 * @Date 2022/3/27 13:18
 * @Version 1.0
 **/
public class LC94 {

    /*
        3种遍历方式
          1递归
          2迭代
            2.1 一种方式
            2.2 另一种方式
          3莫里斯（会改变二叉树原有结构）
     */
    List<Integer> res = new ArrayList();

    //3种遍历方式
    //1递归
    public List<Integer> inorderTraversal1(TreeNode root) {
        dfs(root);
        return res;
    }

    //2.1迭代（用栈）
    public List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (stack.size() > 0 || root != null) {
            //不断往左子树方向走，每走一次就将当前节点保存到栈中
            //这是模拟递归的调用
            if (root != null) {
                stack.add(root);
                root = root.left;
                //当前节点为空，说明左边走到头了，从栈中弹出节点并保存
                //然后转向右边节点，继续上面整个过程
            } else {
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                root = tmp.right;
            }
        }
        return res;
    }

    //2.2迭代另一种写法（用栈）
    public List<Integer> inorderTraversal3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    //3莫里斯遍历
    public List<Integer> inorderTraversal4(TreeNode root) {
        TreeNode pre = null;
        while (root != null) {
            //如果左节点不为空，就将当前节点连带右子树全部挂到
            //左节点的最右子树下面
            if (root.left != null) {
                pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root;
                TreeNode newRoot = root.left;
                root.left = null;
                root = newRoot;
                //左子树为空，则打印这个节点，并向右边遍历
            } else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(4);
//        root.left = new TreeNode(3);
//        root.left.left = new TreeNode(2);
//        root.left.left.left = new TreeNode(1);
//        root.right = new TreeNode(6);
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(7);

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new LC94().inorderTraversal3(root));
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

}

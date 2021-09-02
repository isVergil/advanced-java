package com.algorithm.剑指offer;


import java.util.Stack;

/**
 * @ClassName JZ13
 * @Description TODO
 * @Author bill
 * @Date 2021/8/30 15:31
 * @Version 1.0
 **/

/*
二叉树的镜像


 */
public class JZ27 {

    public static void main(String[] args) {


    }

    //法一 ： 递归
    //先 交换， 再 递归遍历
    public TreeNode mirrorTree1(TreeNode root) {
        //终止条件是 到尾节点
        if (root == null) {
            return null;
        }
        //交换节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree1(root.left);
        mirrorTree1(root.right);
        return root;
    }

    //法二 ： 迭代
    //遍历所有节点  然后交换
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>() {{
            add(root);
        }};
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }

}

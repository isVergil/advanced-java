package com.algorithm.剑指offer;

import java.util.*;

/**
 * @ClassName JZ37   序列化二叉树
 * @Description TODO
 * @Author bill
 * @Date 2021/9/3 9:46
 * @Version 1.0
 **/
/*
 序列化二叉树
 */
public class JZ37 {
    public static void main(String[] args) {

    }

    //队列
    String Serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("#,");
            } else {
                sb.append(node.val + ",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();

    }


    TreeNode Deserialize(String str) {
        if (str == null || "[]".equals(str)) {
            return null;
        }
        str = str.substring(1, str.length() - 1);
        if (!str.contains(",")) {
            return new TreeNode(Integer.valueOf(str));
        }
        String[] strArr = str.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(strArr[0]));
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"#".equals(strArr[i])) {
                node.left = new TreeNode(Integer.valueOf(strArr[i]));
                queue.offer(node.left);
            }
            i++;
            if (!"#".equals(strArr[i])) {
                node.right = new TreeNode(Integer.valueOf(strArr[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }


}

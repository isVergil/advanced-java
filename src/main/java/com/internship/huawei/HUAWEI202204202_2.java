package com.internship.huawei;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName HUAWEI202204202_2
 * @Description TODO
 * @Author bill
 * @Date 2022/6/29 23:44
 * @Version 1.0
 **/
public class HUAWEI202204202_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1 读取第一行并生成二叉树
        String br1 = br.readLine();
        String[] str1 = br1.substring(1, br1.length() - 1).split(",");
        TreeNode root = buildTree(str1);
        //2 读取第二行找到二叉树替换的节点chageNode
        String br2 = br.readLine().substring(1);
        String[] str2 = br2.split("/");
        TreeNode chageNode = root;
        //2.1 找到要替换的节点的上一节点
        for (int i = 1; i < str2.length - 1; i++) {
            if (chageNode.left != null && chageNode.left.val.equals(str2[i])) {
                chageNode = chageNode.left;
            } else {
                chageNode = chageNode.right;
            }
        }
        //3 读取第三行生成要替换的二叉树
        String br3 = br.readLine();
        String[] str3 = br3.substring(1, br3.length() - 1).split(",");
        TreeNode root3 = buildTree(str3);
        //3.1 /1 的情况，即替换整个二叉树，直接打印输出要替换的二叉树即可
        if (str2.length == 1) {
            System.out.println(generateArr(root3));
            return;
        }
        //3.2 替换二叉树
        if (chageNode.left != null && chageNode.left.val.equals(str2[str2.length - 1])) {
            chageNode.left = root3;
        } else {
            chageNode.right = root3;
        }
        //4 打印输出数组
        System.out.println(generateArr(root));
    }

    //生成二叉树
    public static TreeNode buildTree(String[] nums) {
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        deque.offer(root);
        int i = 1, len = nums.length;
        while (!deque.isEmpty()) {
            TreeNode cur = deque.poll();
            if (i < len) {
                if ("0".equals(nums[i])) {
                    cur.left = null;
                } else {
                    cur.left = new TreeNode(nums[i]);
                    deque.offer(cur.left);
                }
            }
            i++;
            if (i < len) {
                if ("0".equals(nums[i])) {
                    cur.right = null;
                } else {
                    cur.right = new TreeNode(nums[i]);
                    deque.offer(cur.right);
                }
            }
            i++;
        }
        return root;
    }

    //打印输出二叉树
    public static StringBuilder generateArr(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode cur = deque.poll();
            sb.append(cur.val + ",");
            if (cur.left != null) {
                deque.offer(cur.left);
            }
            if (cur.right != null) {
                deque.offer(cur.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb;
    }

    //TreeNode 定义
    //注意 val 为 String 类型，方便处理，相应的判断相等要用 equals
    static class TreeNode {
        String val;

        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(String val) {
            this.val = val;
        }

        TreeNode(String val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

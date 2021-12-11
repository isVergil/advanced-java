package com.algorithm.剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName JZ32_1
 * @Description TODO
 * @Author bill
 * @Date 2021/9/3 9:46
 * @Version 1.0
 **/
/*
从上到下打印二叉树 II

从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。


 */
public class JZ32_2 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int queueSize = queue.size();
            while(queueSize > 0){
                TreeNode cur = queue.poll();
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
                temp.add(cur.val);
                queueSize--;
            }
            result.add(temp);
        }
        return result;
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

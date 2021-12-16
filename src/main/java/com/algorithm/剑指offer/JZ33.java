package com.algorithm.剑指offer;

import java.util.*;

/**
 * @ClassName JZ33
 * @Description TODO
 * @Author bill
 * @Date 2021/9/3 9:46
 * @Version 1.0
 **/
/*
二叉搜索树的后序遍历序列

输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。


 */
public class JZ33 {
    public static void main(String[] args) {

    }

    //1、递归分治
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return false;
        }
        return recur(postorder, 0, postorder.length - 1);
    }

    boolean recur(int[] postorder, int i, int j) {
        //遍历到有一边为空的情况即条件终止
        //if(i >= j-1){  也行
        if (i >= j) {
            return true;
        }
        int pivot = i;
        //左子树应该都小于根 postorder[j]
        while (postorder[pivot] < postorder[j]) {
            pivot++;
        }
        //左右子树划分点
        int mid = pivot;
        //右子树应该都大于根 postorder[j]
        while (postorder[pivot] > postorder[j]) {
            pivot++;
        }
        return pivot == j && recur(postorder, i, mid - 1) && recur(postorder, mid, j - 1);
    }

    //2、单调栈 https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
    boolean verifyPostorder1(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;

    }

}

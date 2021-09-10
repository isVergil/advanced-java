package com.algorithm.剑指offer;

import java.util.HashMap;
import java.util.Map;

/*
重建二叉树

输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

来源：力扣（LeetCode）
https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JZ07 {
    public static void main(String[] args) {

    }

    //preorder  1****
    //inorder   **1**
    //用 inorder 来划分 preorder 的左右子树
    int[] pre;
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        pre = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    //先序索引 root
    //中序索引 left
    //中序索引 right
    public TreeNode recur(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootPivot = map.get(pre[root]);
        TreeNode rootTree = new TreeNode(pre[root]);
        rootTree.left = recur(root + 1, left, rootPivot - 1);
        //根节点索引 + 左子树长度 + 1
        rootTree.right = recur(root + rootPivot - left + 1, rootPivot + 1, right);
        return rootTree;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

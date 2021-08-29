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

    //利用原理,先序遍历的第一个节点就是根。在中序遍历中通过根 区分哪些是左子树的，哪些是右子树的
    //左右子树，递归
    int preCopy[];
    Map<Integer, Integer> map = new HashMap<>();


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preCopy = preorder;
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length);
    }

    //root  先序遍历的索引
    //left  中序遍历的索引
    //right 中序遍历的索引
    private TreeNode recur(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preCopy[root]);
        //划分preorder
        int i = map.get(root);
        treeNode.left = recur(root + 1, left, i - 1);
        treeNode.right = recur(root + i - left + 1, i + 1, right);
        return treeNode;
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

package com.algorithm.LeetCode热题HOT100;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LC105
 * @Description 从前序与中序遍历序列构造二叉树
 * @Author bill
 * @Date 2022/3/17 16:41
 * @Version 1.0
 **/
public class LC105 {

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(preorder, 0, 0, preorder.length - 1);
    }

    public TreeNode recur(int[] preorder, int root, int ileft, int iright) {
        if (ileft > iright) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[root]);
        int rootpivot = map.get(preorder[root]);
        node.left = recur(preorder, root + 1, ileft, rootpivot - 1);
        node.right = recur(preorder, root + 1 + rootpivot - ileft, rootpivot + 1, iright);
        return node;
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

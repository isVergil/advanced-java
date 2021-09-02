package com.algorithm.剑指offer;


/**
 * @ClassName JZ13
 * @Description TODO
 * @Author bill
 * @Date 2021/8/30 15:31
 * @Version 1.0
 **/

/*
树的子结构

输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

B是A的子结构， 即 A中有出现和B相同的结构和节点值。

 */
public class JZ26 {

    public static void main(String[] args) {


    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        //遍历A中每个节点，A树中任一节点包含B就能返回true
        return iscontain(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    boolean iscontain(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return iscontain(A.left, B.left) && iscontain(A.right, B.right);
    }

}

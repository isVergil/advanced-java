package com.algorithm.剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JZ08
 * @Description TODO
 * @Author bill
 * @Date 2021/11/5 16:31
 * @Version 1.0
 **/
/*
JZ8 二叉树的下一个结点

https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=23451&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class JZ08 {

    //法1 ：遍历存进 list 取值赋值
    List<TreeLinkNode> list = new ArrayList<>();
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null){
            return null;
        }
        TreeLinkNode root = pNode;
        while(root.next != null){
            root = root.next;
        }
        dfs(root);
        for(int i = 0; i < list.size(); i++){
            if(pNode == list.get(i)){
                if(i < (list.size() - 1)){
                    return list.get(i + 1);
                }
                break;
            }
        }
        return null;
    }

    void dfs(TreeLinkNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }

    //法2 直接找
    //1 node 有右子树 则 node 的下一个就是 node 右子树的最左子节点
    //2 node 没有右子树 则向上找父节点，直到 当前节点 是其父节点的左节点则 该父节点为所求
    //3 其他情况返回null 比如只有一个节点
    public TreeLinkNode GetNext1(TreeLinkNode pNode) {
        if(pNode == null){
            return null;
        }
        if(pNode.right != null){
            pNode = pNode.right;
            while(pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        while(pNode.next != null){
            if(pNode.next.left == pNode){
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;

    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}

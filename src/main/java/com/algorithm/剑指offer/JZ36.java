package com.algorithm.剑指offer;

import java.util.HashMap;

/**
 * @ClassName JZ34
 * @Description TODO
 * @Author bill
 * @Date 2021/9/3 9:46
 * @Version 1.0
 **/
/*
 复杂链表的复制
 */
public class JZ36 {
    public static void main(String[] args) {

    }

    Node head, prev;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        //中序遍历
        dfs(root);
        //连接头尾
        head.left = prev;
        prev.right = head;
        return head;
    }

    public void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        //中序遍历
        dfs(cur.left);
        if (prev == null) {
            head = cur;       //prev == null 说明 cur 是头节点
        } else {
            prev.right = cur;  //prev != null  则right连接 prev 和 cur
        }
        cur.left = prev;       //prev != null  则left连接  prev 和 cur
        prev = cur;            //prev 右移一位
        dfs(cur.right);
    }

}

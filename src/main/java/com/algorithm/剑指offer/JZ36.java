package com.algorithm.剑指offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    //法1
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


    //法2
    List<Node> list = new ArrayList();

    public Node Convert(Node pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        dfs1(pRootOfTree);
        for (int i = 1; i < list.size(); i++) {
            list.get(i - 1).right = list.get(i);
            list.get(i).left = list.get(i - 1);
        }
        return list.get(0);
    }

    void dfs1(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(new Node(root.val));
        dfs(root.right);
    }
}

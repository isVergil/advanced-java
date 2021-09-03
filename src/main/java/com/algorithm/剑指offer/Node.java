package com.algorithm.剑指offer;

/**
 * @ClassName Node
 * @Description TODO
 * @Author bill
 * @Date 2021/9/3 12:21
 * @Version 1.0
 **/
public class Node {
    //JZ36
    Node left;
    Node right;

    //JZ35
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

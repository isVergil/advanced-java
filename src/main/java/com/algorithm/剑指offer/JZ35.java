package com.algorithm.剑指offer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
public class JZ35 {
    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }
        current = head;
        while (current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }

}

package com.algorithm.LeetCode热题HOT100;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName LC23
 * @Description 23. 合并K个升序链表
 * @Author bill
 * @Date 2022/3/20 15:52
 * @Version 1.0
 **/
public class LC23 {

    //1、朴素写法 化简为 合并2个升序链表 两两合并
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (ListNode head : lists) {
            res = mergeTwoLists(res, head);
        }
        return res;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }

    //2、k个元素的小根堆
    public ListNode mergeKLists1(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode node: lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = minNode;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return dummyHead.next;
    }





    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

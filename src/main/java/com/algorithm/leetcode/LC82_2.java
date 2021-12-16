package com.algorithm.leetcode;

/**
 * @ClassName LC82_2
 * @Description TODO
 * @Author bill
 * @Date 2021/11/2 19:01
 * @Version 1.0
 **/
/*
82. 删除排序链表中的重复元素 II
 */
public class LC82_2 {

    //法1：一次遍历 制造一个temphead节点指向head
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temphead = new ListNode(200);
        temphead.next = head;
        ListNode cur = temphead;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return temphead.next;
    }

    //法2：递归
    public ListNode deleteDuplicates1(ListNode head) {
        //条件终止
        if (head == null || head.next == null) {
            return head;
        }
        //不相等 则继续遍历下一点
        if (head.val != head.next.val) {
            head.next = deleteDuplicates1(head.next);
        //相等  则遍历完连续相等的节点 ，并将第一个不等的点返回
        } else {
            ListNode temp = head.next;
            while (temp != null && head.val == temp.val) {
                temp = temp.next;
            }
            return deleteDuplicates1(temp);
        }
        return head;
    }

    class ListNode {
        int val;

        ListNode(int x) {
            val = x;
        }

        ListNode next;
    }
}

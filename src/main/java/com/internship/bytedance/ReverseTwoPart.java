package com.internship.bytedance;

import java.util.List;

/**
 * @ClassName ReverseTwoPart
 * @Description TODO
 * @Author bill
 * @Date 2021/9/17 15:49
 * @Version 1.0
 **/
/*
算法题：给一个链表，从中间断开，然后两部分分别翻转后再拼接上，其中的 翻转链表（要求原地翻转）。
 */
public class ReverseTwoPart {

    //1、找中间节点 返回的是后半段的链表！！！
    //快慢指针
    //链表分为前半部分head 后半部分 mid
    public ListNode findMiddleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    //2、反转链表
    public ListNode reverseNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    //3、合并反转后的链表
    //调用前面两个方法
    public ListNode reverseListNode(ListNode head) {
        if (head == null) {
            return null;
        }
        //找到中间节点
        ListNode mid = findMiddleNode(head);
        //反转
        ListNode left = reverseNode(head);
        ListNode right = reverseNode(mid);
        //链接
        ListNode leftLast = left;
        while (leftLast.next != null) {
            leftLast = leftLast.next;
        }
        leftLast.next = right;
        return left;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}

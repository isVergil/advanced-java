package com.algorithm.LeetCode热题HOT100;

/**
 * @ClassName LC2
 * @Description TODO
 * @Author bill
 * @Date 2021/10/28 20:47
 * @Version 1.0
 **/
/*
两数相加
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class LC2 {
    //1、求和
    //2、进位
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        while (head1 != null) {
            if (head2 != null) {
                head1.val += head2.val;
                head2 = head2.next;
            }
            if (head1.next == null && head2 != null) {
                head1.next = head2;
                break;
            }
            head1 = head1.next;
        }
        //此时head1 就是 两个链表值相加之后的结果
        //处理进位
        ListNode head3 = l1;
        while (head3 != null) {
            if (head3.val >= 10) {
                head3.val %= 10;
                if (head3.next == null) {
                    head3.next = new ListNode(1);
                    break;
                }
                head3.next.val += 1;
            }
            head3 = head3.next;
        }
        return l1;
    }


    class ListNode {
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

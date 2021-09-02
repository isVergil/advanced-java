package com.algorithm.剑指offer;


/**
 * @ClassName JZ13
 * @Description TODO
 * @Author bill
 * @Date 2021/8/30 15:31
 * @Version 1.0
 **/

/*
反转链表

定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

 */
public class JZ24 {

    public static void main(String[] args) {

    }

    //1、双指针
    public ListNode reverseList1(ListNode head) {
        ListNode cur = null, pre = head;
        while (pre != null) {
            ListNode temp = cur;
            cur = pre;
            pre = pre.next;
            cur.next = temp;
        }
        return cur;
    }

    //2、双指针2
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (head.next != null) {
            ListNode temp = head.next.next;
            head.next.next = cur;
            cur = head.next;
            head.next = temp;
        }
        return cur;
    }

    //3、递归
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}

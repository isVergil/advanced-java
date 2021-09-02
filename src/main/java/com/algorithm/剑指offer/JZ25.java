package com.algorithm.剑指offer;


/**
 * @ClassName JZ13
 * @Description TODO
 * @Author bill
 * @Date 2021/8/30 15:31
 * @Version 1.0
 **/

/*
合并两个排序的链表

输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

 */
public class JZ25 {

    public static void main(String[] args) {
        new JZ25().mergeTwoLists(new ListNode(1), new ListNode(2));
    }

    //法1 伪头节点法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //双指针
        ListNode left = l1;
        ListNode right = l2;
        ListNode newHead = new ListNode(-1);
        ListNode tempHead = newHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tempHead.next = new ListNode(left.val);
                left = left.next;
            } else {
                tempHead.next = new ListNode(right.val);
                right = right.next;
            }
            tempHead = tempHead.next;
        }
//        if (left == null) {
//            tempHead.next = right;
//        } else {
//            tempHead.next = left;
//        }
        tempHead.next = (left != null) ? left : right;
        return newHead.next;
    }

    //法2 递归
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

}

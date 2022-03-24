package com.algorithm.LeetCode热题HOT100;

/**
 * @ClassName LC21
 * @Description 21. 合并两个有序链表
 * @Author bill
 * @Date 2022/3/20 15:19
 * @Version 1.0
 **/
public class LC21 {

    //1、递归
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val >= list2.val) {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        } else {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }

    }

    //2、创建伪头节点
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode newhead = new ListNode(0);
        ListNode temp = newhead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = (l1 != null ? l1 : l2);
        return newhead.next;

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

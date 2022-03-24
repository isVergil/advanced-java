package com.algorithm.LeetCode热题HOT100;

/**
 * @ClassName LC2
 * @Description TODO
 * @Author bill
 * @Date 2021/10/28 20:47
 * @Version 1.0
 **/
/*
两数相加   同 NC317 链表相加(一)
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

    //同上   两数相加   同 NC317 链表相加(一)
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode newHead = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            dummyHead.next = new ListNode(sum % 10);
            dummyHead = dummyHead.next;
        }
        if (carry > 0) {
            dummyHead.next = new ListNode(carry);
        }
        return newHead.next;
    }

    //NC40 链表相加(二)
    public ListNode addInList(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        head1 = reverse(head1);
        head2 = reverse(head2);
        ListNode head = new ListNode(-1);
        ListNode headRet = head;
        int tmp = 0;
        while (head1 != null || head2 != null) {
            int sum = tmp;
            if (head1 != null) {
                sum += head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.val;
                head2 = head2.next;
            }
            tmp = sum / 10;
            head.next = new ListNode(sum % 10);
            head = head.next;
        }
        if (tmp != 0) {
            head.next = new ListNode(tmp);
        }
        return reverse(headRet.next);

    }

    public ListNode reverse(ListNode node) {
        if (node == null) return null;
        ListNode curr = null;
        ListNode pre = node;
        while (pre != null) {
            ListNode tmp = pre.next;
            pre.next = curr;
            curr = pre;
            pre = tmp;
        }
        return curr;
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

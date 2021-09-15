package com.internship.bytedance;

/**
 * @ClassName LC_328
 * @Description TODO
 * @Author bill
 * @Date 2021/9/14 15:40
 * @Version 1.0
 **/
/*
奇偶链表
给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 */
public class LC_328 {
    //即把奇数位的链表 和 偶数位的链表 分离
    //最后 奇数位的链表的尾指向偶数链表的头即可
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode ouHead = head.next;
        ListNode jiHead = head, curOu = ouHead;
        while (curOu != null && curOu.next != null) {
            jiHead.next = curOu.next;
            jiHead = jiHead.next;
            curOu.next = jiHead.next;
            curOu = curOu.next;
        }
        jiHead.next = ouHead;
        return head;
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

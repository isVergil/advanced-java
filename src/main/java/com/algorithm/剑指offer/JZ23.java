package com.algorithm.剑指offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName JZ23
 * @Description TODO
 * @Author bill
 * @Date 2022/1/7 20:54
 * @Version 1.0
 **/
/*
链表中环的入口结点
 */
public class JZ23 {

    //法1 哈希表
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        Set<ListNode> set = new HashSet();
        while (pHead != null) {
            if (set.contains(pHead)) {
                return pHead;
            } else {
                set.add(pHead);
                pHead = pHead.next;
            }
        }
        return null;
    }

    //法2 快慢指针 + 公式推导
    //两个指针 fast 与  slow。它们起始都位于链表的头部。
    //设链表中环外部分的长度为 a  指针进入环后  b 的距离与 fast 相遇 剩下的距离 设为 c
    //则 slow 走的长度 a + b + n1 * ( b + c )
    //则 fast 走的长度 a + b + n2 * ( b + c )
    //两倍关系 则 a + (2 * n1 - n2 + 1) * b + (2 * n1 - n2 ) * c = 0;
    //即得 a = c +  (n2 - 2 * n1 - 1) * (b + c)
    //即现在 指针 从链表开始 走长度 a 得距离 正好 等于 指针 从相遇点走 c 得距离 + n 个环得距离 他们总会相遇
    public ListNode EntryNodeOfLoop1(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead, fast = pHead;
        while (fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            } else {
                fast = fast.next.next;
            }
            //相遇
            if (slow == fast) {
                ListNode cur = pHead;
                while (cur != slow) {
                    cur = cur.next;
                    slow = slow.next;
                }
                return cur;
            }
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}

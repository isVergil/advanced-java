package com.algorithm.LeetCode热题HOT100;

import java.util.*;

/**
 * @ClassName LC19
 * @Description 19. 删除链表的倒数第 N 个结点
 * @Author bill
 * @Date 2022/3/17 15:07
 * @Version 1.0
 **/
public class LC19 {

    //法1 计算链表长度
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0, head);
        ListNode cur = dummyHead;
        int len = getLength(head);
        for (int i = 1; i < len - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummyHead.next;
    }

    public int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    //法2 栈
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    //法3 前后指针
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
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

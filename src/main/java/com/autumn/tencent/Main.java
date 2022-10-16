package com.autumn.tencent;

/**
 * @ClassName Main
 * @Description TODO
 * @Author bill
 * @Date 2022/10/16 20:01
 * @Version 1.0
 **/
public class Main {

    public ListNode xorList(ListNode a, ListNode b) {
        if (b == null) {
            return a;
        }
        b = reverse(b);
        if (a == null) {
            return b;
        }
        int lenA = 0, lenB = 0;
        ListNode cur = a;
        while (cur != null) {
            lenA++;
            cur = cur.next;
        }
        cur = b;
        while (cur != null) {
            lenB++;
            cur = cur.next;
        }
        ListNode dummyNode = new ListNode(0);
        cur = dummyNode;
        if (lenA == lenB) {
            while (a != null) {
                cur.next = new ListNode(a.val ^ b.val);
                a = a.next;
                b = b.next;
                cur = cur.next;
            }
        } else if (lenA > lenB) {
            int len = lenA - lenB;
            while (len-- > 0) {
                cur.next = new ListNode(a.val);
                a = a.next;
                cur = cur.next;
            }
            while (a != null) {
                cur.next = new ListNode(a.val ^ b.val);
                a = a.next;
                b = b.next;
                cur = cur.next;
            }
        } else {
            int len = lenB - lenA;
            while (len-- > 0) {
                cur.next = new ListNode(b.val);
                b = b.next;
                cur = cur.next;
            }
            while (a != null) {
                cur.next = new ListNode(a.val ^ b.val);
                a = a.next;
                b = b.next;
                cur = cur.next;
            }
        }
        while (dummyNode != null && dummyNode.val == 0) {
            dummyNode = dummyNode.next;
        }
        if (dummyNode != null && dummyNode.val == 0) {
            return null;
        }
        if (dummyNode == null) {
            return new ListNode(0);
        }
        return dummyNode;

    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }


    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

}

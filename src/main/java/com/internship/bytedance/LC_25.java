package com.internship.bytedance;


/**
 * @ClassName LC_25
 * @Description TODO
 * @Author bill
 * @Date 2021/9/17 16:33
 * @Version 1.0
 **/
/*
 K 个一组翻转链表
 */
public class LC_25 {

    public static void main(String[] args) {
        new LC_25().test();
    }

    public void test() {
        ListNode tempHead = new ListNode(1);
        tempHead.next = new ListNode(2);
        tempHead.next.next = new ListNode(3);
        tempHead.next.next.next = new ListNode(4);
        tempHead.next.next.next.next = new ListNode(5);
        tempHead.next.next.next.next.next = null;
        reverseKGroup(tempHead, 2);
        System.out.println(tempHead);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tempHead = new ListNode(0);  //定义一个暂时的头节点
        tempHead.next = head;
        ListNode prev = tempHead, end = tempHead;  //pre,end 都指向 k 个一组链表的尾节点
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = prev.next;    //需要反转的头节点
            ListNode next = end.next;
            end.next = null;               //断开end
            prev.next = reverse(start);    //翻转链表
            start.next = next;             //反转后 start 就是 尾节点
            prev = start;
            end = start;
        }
        return tempHead.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
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

        @Override
        public String toString() {
            ListNode temp = this;
            StringBuilder sb = new StringBuilder();
            while (temp != null) {
                sb.append(temp.val + "->");
                temp = temp.next;
            }
            return sb.toString();
        }
    }
}

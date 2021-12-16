package com.algorithm.剑指offer;

/**
 * @ClassName JZ52
 * @Description TODO
 * @Author bill
 * @Date 2021/11/1 17:00
 * @Version 1.0
 **/
public class JZ52 {
    //不会陷入死循环，因为若没有交点 则 最后 tempA == tempB == null 也会退出循环
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

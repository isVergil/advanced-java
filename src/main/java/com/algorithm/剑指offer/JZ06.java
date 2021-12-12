package com.algorithm.剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
从尾到头打印链表

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

来源：力扣（LeetCode）
https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JZ06 {
    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        ListNode node1 = new ListNode(89);
//        ListNode node2 = new ListNode(68);
//        ListNode node3 = new ListNode(134);
//        ListNode node4 = new ListNode(5);
//        head.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = null;
//        System.out.println(head);
//        new JZ06().reversePrint1(head);
    }

    //方法1 遍历，用栈来存储结点，出栈即为新结点
    //O(n)  O(n)
    public int[] reversePrint1(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        if (head.next == null) {
            return new int[]{head.val};
        }
        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;
        //入栈
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        //出栈
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    //方法2 递归调用
    //O(n)  O(n)
    ArrayList<Integer> tmp = new ArrayList<Integer>();

    public int[] reversePrint2(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = tmp.get(i);
        return res;
    }

    void recur(ListNode head) {
        if (head == null) return;
        recur(head.next);
        tmp.add(head.val);
    }

    //方法3 另外一种递归调用
    //O(n)  O(n)
    int[] res;
    int i = 0;
    int j = 0;

    public int[] reversePrint3(ListNode head) {
        solve(head);
        return res;
    }

    public void solve(ListNode head) {
        if (head == null) {
            res = new int[i];
            return;
        }
        i++;
        solve(head.next);
        res[j] = head.val;
        j++;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.val);
            ListNode temp = this.next;
            while (temp != null) {
                sb.append(" -> " + temp.val);
                temp = temp.next;
            }
            return sb.toString();
        }
    }
}



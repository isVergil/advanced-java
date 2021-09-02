package com.algorithm.剑指offer;


/**
 * @ClassName JZ13
 * @Description TODO
 * @Author bill
 * @Date 2021/8/30 15:31
 * @Version 1.0
 **/

/*
链表中倒数第k个节点

输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。

例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class JZ22 {

    public static void main(String[] args) {

    }

    //前后指针，former先走 k 步， 然后 latter 走，这样间隔就是 k
    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode former = head, latter = head;
        for(int i = 0; i < k; i++){
            former = former.next;
        }
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }

    // 引入 t 来代替第一个for循环 更加简洁  O(N)
    public ListNode getKthFromEnd2(ListNode head, int k) {

         ListNode slow=head,fast=head;
         int t = 0;
         while(fast!=null){
             if(t>=k) slow=slow.next;
             fast = fast.next;
             t++;
         }
         return slow;
    }

}

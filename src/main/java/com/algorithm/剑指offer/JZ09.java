package com.algorithm.剑指offer;

import java.util.Stack;

/*
用两个栈实现队列

用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JZ09 {
    public static void main(String[] args) {

    }
}

class CQueue {

    private Stack<Integer> stack1;

    private Stack<Integer> stack2;

    public CQueue() {
        //stack1 入栈作为入队
        stack1 = new Stack<>();
        //stack2 出栈作为出队
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

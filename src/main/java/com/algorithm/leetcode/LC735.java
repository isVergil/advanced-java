package com.algorithm.leetcode;

import java.util.Stack;

/**
 * @ClassName LC735
 * @Description 735. 行星碰撞
 * @Author bill
 * @Date 2022/5/4 17:09
 * @Version 1.0
 **/
//快手
public class LC735 {

    //用栈实现
    public int[] asteroidCollision(int[] asteroids) {
        //Deque<Integer> stack = new ArrayDeque();
        //ArrayDeque 实现的话 遍历是从栈顶开始 与 stack 遍历不同
        Stack<Integer> stack = new Stack();
        int index = 0, len = asteroids.length;
        while (index < len) {
            if (!stack.isEmpty() && asteroids[index] < 0 && stack.peek() > 0) {
                int peek = stack.peek();
                if (peek < -asteroids[index]) {   //左边行星质量小 爆炸
                    stack.pop();
                } else if (peek > -asteroids[index]) {   //右边行星质量小 爆炸
                    index++;
                } else {    //行星质量相等 一起爆炸
                    stack.pop();
                    index++;
                }
            } else {  // 如果栈为空 或者 栈顶的行星 和 idx位置的行星 不符合相撞条件 直接push
                stack.push(asteroids[index++]);
            }
        }
        int[] res = new int[stack.size()];
        //stack 遍历从栈底开始
        if (stack.size() > 0) {
            index = 0;
            for (int item : stack) {
                res[index++] = item;
            }
        }
        return res;
    }


}

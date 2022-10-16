package com.algorithm.单调栈;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName Test
 * @Description TODO
 * @Author bill
 * @Date 2022/8/14 22:21
 * @Version 1.0
 **/
public class Test {

    //962. 最大宽度坡
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        LinkedList<Integer> stack = new LinkedList();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[i] > nums[stack.peek()]) {
                stack.push(i);
            }
        }
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                res = Math.max(res, nums[stack.pop()]);
            }
        }
        return res;
    }
}

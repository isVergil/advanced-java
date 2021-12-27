package com.algorithm.剑指offer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName JZ41   连续子数组的最大和
 * @Description TODO
 * @Author bill
 * @Date 2021/9/3 9:46
 * @Version 1.0
 **/
/*
连续子数组的最大和
 */
public class JZ42 {
    public static void main(String[] args) {

    }

    //动态规划
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = nums[i] + dp[i - 1];
            } else {
                dp[i] = nums[i];
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    //动态规划 优化
    public int FindGreatestSumOfSubArray(int[] array) {
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] >= 0) {
                array[i] = array[i] + array[i - 1];
            }
            //array[i] = Math.max(array[i] + array[i - 1], array[i]);
            res = Math.max(array[i], res);
        }
        return res;
    }

}

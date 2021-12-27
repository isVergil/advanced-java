package com.algorithm.剑指offer;

import java.util.Arrays;

/**
 * @ClassName JZ85
 * @Description TODO
 * @Author bill
 * @Date 2021/11/21 20:35
 * @Version 1.0
 **/
/*
连续子数组的最大和(二)
输出结果
 */
public class JZ85 {

    public int[] FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int left = 0, right = 0, skipLeft = 0, skipRight = 0, maxLength = 1;
        int maxSum = array[0];
        for (int i = 1; i < array.length; i++) {
            right++;
            dp[i] = Math.max(array[i], array[i] + dp[i - 1]);
            //dp[i-1]为负数时无贡献，重新记录起始位置
            if (array[i] + dp[i - 1] < array[i]) {
                left = right;
            }
            //如果存在多个最大和的连续子数组，那么返回其中长度最长的，保证这个最长的只存在一个
            //运算优先级 == > && > ||
            if (dp[i] > maxSum || dp[i] == maxSum && (right - left + 1) > maxLength) {
                skipLeft = left;     //记录最大子数组起始位置
                skipRight = right;   //记录最大子数组结束位置
                maxLength = right - left + 1;    //记录最大子数组长度
                maxSum = dp[i];
            }
        }
        return Arrays.copyOfRange(array, skipLeft, skipRight + 1);
    }

    public int[] FindGreatestSumOfSubArray1(int[] array) {
        int sum = array[0], num = array[0];
        int tmpleft = 0, tmpright = 1;
        int left = 0, right = 1;
        for (int i = 1; i < array.length; i++) {
            //num 相当于 dp[i]
            if (array[i] > num + array[i]) {
                num = array[i];
                tmpleft = i;
                tmpright = i + 1;
            } else {
                num = num + array[i];
                tmpright++;
            }

            if (num >= sum) {
                sum = num;
                left = tmpleft;
                right = tmpright;
            }
        }
        return Arrays.copyOfRange(array, left, right);
    }

}

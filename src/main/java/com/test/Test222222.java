package com.test;


import java.util.Arrays;

/**
 * @ClassName Test222222
 * @Description TODO
 * @Author bill
 * @Date 2022/8/16 21:30
 * @Version 1.0
 **/
public class Test222222 {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums1 = {5, 4, -1, 7, 8};
        int[] nums2 = {5, 4, -1, 7, 8};
        System.out.println(findMaxLenSumArr(nums));
        System.out.println(findMaxLenSumArr(nums1));
        System.out.println(findMaxLenSumArr(nums2));
    }

    static int findMaxLenSumArr(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];
        int l = 0;
        int res = 1;
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                l = i;
                dp[i] = nums[i];
            }
            //遇到最大值 就更新长度
            if (dp[i] >= max) {
                res = Math.max(i - l + 1, res);
                max = dp[i];
            }
        }
        return res;
    }


}

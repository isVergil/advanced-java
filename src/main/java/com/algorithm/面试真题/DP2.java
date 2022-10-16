package com.algorithm.面试真题;

import java.util.Scanner;

/**
 * @ClassName DP2
 * @Description TODO
 * @Author bill
 * @Date 2022/7/18 19:04
 * @Version 1.0
 **/
public class DP2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int nums[] = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            dp(nums, k);
        }
    }

    public static void dp(int[] nums, int K) {
        //在前i个数的范围上(0...i-1)，一定选j个数，加起来是偶数的子序列个数
        //在前i个数的范围上(0...i-1)，一定选j个数，加起来是奇数的子序列个数
        int[][] even = new int[nums.length + 1][K + 1];
        int[][] odd = new int[nums.length + 1][K + 1];
        for (int i = 0; i < nums.length; i++) {
            even[i][0] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= K; j++) {
                even[i][j] = even[i - 1][j];
                odd[i][j] = odd[i - 1][j];
                //当前为偶数
                if (nums[i - 1] % 2 == 0) {
                    //和为偶数 + 一个偶数 = 和为偶数
                    even[i][j] += even[i - 1][j - 1];
                    //和为奇数 + 一个偶数 = 和为奇数
                    odd[i][j] += odd[i - 1][j - 1];
                } else {
                    //和为偶数 + 一个奇数 = 和为奇数
                    odd[i][j] += even[i - 1][j - 1];
                    //和为奇数 + 一个奇数 = 和为偶数
                    even[i][j] += odd[i - 1][j - 1];
                }
            }
        }
        System.out.println(even[nums.length][K]);

    }


}

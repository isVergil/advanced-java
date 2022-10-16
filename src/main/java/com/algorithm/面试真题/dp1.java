package com.algorithm.面试真题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName dp1
 * @Description 小红取数
 * https://www.nowcoder.com/practice/6a7b2b6c9e3a4f56b1db9f8ca08d889b
 * @Author bill
 * @Date 2022/6/22 18:08
 * @Version 1.0
 **/
public class dp1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long[] nums = new long[n];
        //dp[i][j] = 前 i 个数 余数为 j 的最大和
        long[][] dp = new long[n + 1][k];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextLong();
            //必须满足它是严格从初始状态转移过来的，在中间不能出现别的状态转移。
            //所以在初始化数组时，必须将df[0][1,2,...k-1]全部初始化成最小的long long值，以保证就算将全部输入的数与其相加都不会得正，
            Arrays.fill(dp[i], Long.MIN_VALUE);

        }
        Arrays.fill(dp[n], -1);
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][(int) ((j + nums[i - 1]) % k)] = Math.max(dp[i - 1][j] + nums[i - 1], dp[i - 1][(int) ((j + nums[i - 1]) % k)]);
            }
        }
        System.out.println(dp[n][0] <= 0 ? -1 : dp[n][0]);
    }

    //小红拿到了一个数组，她想取一些数使得取的数之和尽可能大，但要求这个和必须是 k  的倍数。
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long[] arr = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextLong();
        }
        //dp数组，dp[i][j]表示前i个数中除以k的余数为j的当前最大和
        long[][] dp = new long[n + 1][k];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Long.MIN_VALUE);
            //Arrays.fill(dp[i], -1);
        }
        //状态初始化，0个数时，最大和必为0
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < k; j++) {
                /*如果前一个状态余数为j，则更新当前余数为(j+arr[i])%k的情况，要么从余数为j的状态转化过来，
                要么前一个状态余数也是(j+arr[i])%k，即不选择当前元素*/
                dp[i][(int) ((j + arr[i]) % k)] = Math.max(dp[i - 1][j] + arr[i], dp[i - 1][(int) ((j + arr[i]) % k)]);
            }
        }

        //如果小于等于0，说明不能由初始状态转化过来，没有合法方案
        if (dp[n][0] <= 0) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n][0]);
        }


    }
}

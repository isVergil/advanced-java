package com.algorithm.面试真题;

import java.util.Scanner;

/**
 * @ClassName DP3
 * @Description TODO
 * @Author bill
 * @Date 2022/7/18 19:47
 * @Version 1.0
 **/
public class DP3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next().trim();
        int[][] dp = new int[s.length() + 1][9];
        int MOD = 1000000007;
        for (int i = 1; i <= s.length(); i++) {
            int m = (s.charAt(i - 1) - '0') % 9;
            dp[i][m] = 1;
            for (int j = 0; j < 9; j++) {
                dp[i][j] += (dp[i - 1][j] + dp[i - 1][(j + 9 - m) % 9]) % MOD;
            }
        }
        System.out.println(dp[s.length()][0]);
    }
}

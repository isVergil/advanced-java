package com.internship.wangyi;

import java.util.Scanner;

/**
 * @ClassName Test3
 * @Description TODO
 * @Author bill
 * @Date 2022/4/21 20:04
 * @Version 1.0
 **/
public class Test3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            dp[scanner.nextInt()][scanner.nextInt()] = scanner.nextInt();
        }
        int res = -1;
        if (dp[1][n] != 0 || dp[n][1] != 0) {
            if (dp[1][n] == 0) {
                res = dp[n][1];
            } else if (dp[n][1] == 0) {
                res = dp[1][n];
            } else {
                res = Math.min(dp[1][n], dp[n][1]);
            }
        } else {
            for (int i = 1; i <= n; i++) {
                for (int j = 2; j <= n; j++) {
                    dp[i][j] = dp[i][j - dp[i][j - 1]];
                }
            }
        }
        System.out.println(res);
    }

}

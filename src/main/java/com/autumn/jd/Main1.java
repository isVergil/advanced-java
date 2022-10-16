package com.autumn.jd;

import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description TODO
 * @Author bill
 * @Date 2022/8/27 20:16
 * @Version 1.0
 **/
public class Main1 {

    static int Mod = (int) 1e9 + 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 6) {
            System.out.println(0);
        } else if (n == 6) {
            System.out.println(1);
        } else {
            // int[] dp = new int[n + 1];
            // dp[4] = 26;
            // dp[6] = 1;
            // for (int i = 7; i <= n; i++) {
            //     dp[i] = (dp[i - 1] * 26 + dp[i - 3]) % Mod;
            // }
            System.out.println((long) (n - 4) * (n - 5) % Mod * Math.pow(26, n - 6) % Mod);
        }
    }
}

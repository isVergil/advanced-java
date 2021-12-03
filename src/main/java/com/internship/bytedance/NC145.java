package com.internship.bytedance;

/**
 * @ClassName NC145
 * @Description TODO
 * @Author bill
 * @Date 2021/12/3 15:38
 * @Version 1.0
 **/
/*
01背包
 */
public class NC145 {
    public int knapsack(int V, int n, int[][] vw) {
        //dp[n][v]表示背包体积为 v 的情况下 任选前 n 个物品 能装的最大重量是多少
        int[] dp = new int[V + 1];
        for (int i = 1; i <= n; i++) {
            for (int v = V; v >= 1; v--) {
                //背包容量大于要装入物品的容量
                if (v >= vw[i - 1][0]) {
                    dp[v] = Math.max(dp[v - vw[i - 1][0]] + vw[i - 1][1], dp[v]);
                }
            }
        }
        return dp[V];
    }
}

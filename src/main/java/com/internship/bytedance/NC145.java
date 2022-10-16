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

    //未简化 比较通俗
    public int knapsack1(int v, int n, int[][] vw) {
        int[][] dp = new int[n + 1][v + 1];
        for (int i = 1; i <= n; i++) {  //物品遍历
            for (int j = 1; j <= v; j++) {    //容量遍历
                if (vw[i - 1][0] > j) {       //第 i - 1 个物品容量 >j 他无法被装下
                    dp[i][j] = dp[i - 1][j];
                } else {                      //第 i - 1 个物品能装下就比较 他装与不装的价值最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - vw[i - 1][0]] + vw[i - 1][1]);
                }
            }
        }
        return dp[n][v];
    }

    //后无效性原则 ： 当前状态只与上一个有关，而与上上一个无关
    //滚动数组优化
    //为什么第二层循环（遍历背包容量）要从后往前遍历：若从前往后会覆盖数据
    //dp[j - vw[i - 1][0]] + vw[i - 1][1] 可能小于 j 从前往后会遍历的话 取的就是当前层的数据 而不是上一层
    public int knapsack2(int v, int n, int[][] vw) {
        int[] dp = new int[v + 1];
        for (int i = 1; i <= n; i++) {  //物品遍历
            for (int j = v; j >= 1; j--) {   //容量遍历
                if (vw[i - 1][0] <= j) {   //第i- 1 个物品容量 >j 他无法被装下
                    dp[j] = Math.max(dp[j], dp[j - vw[i - 1][0]] + vw[i - 1][1]);
                }
            }
        }
        return dp[v];
    }

}

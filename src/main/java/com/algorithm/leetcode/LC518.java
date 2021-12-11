package com.algorithm.leetcode;

/**
 * @ClassName LC518
 * @Description TODO
 * @Author bill
 * @Date 2021/12/5 16:42
 * @Version 1.0
 **/
/*
零钱兑换 II
 */
public class LC518 {
    //注意 dp[0] = 1
    //和为 0 的组合只有一种 那就是全都不选
     public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}

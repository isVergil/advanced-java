package com.internship.bytedance;

import java.util.Arrays;

/**
 * @ClassName LC_322
 * @Description TODO
 * @Author bill
 * @Date 2021/9/16 13:50
 * @Version 1.0
 **/
public class LC_322 {

    //法1 动态规划
    //dp[i] 表示金额为 i 的最小硬币数量  dp[0] = 0
    //状态方程  dp[i] = Math.min(dp[i], dp[i - coin] + 1);
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                //有多余的钱放硬币 即 放硬币
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

    }


    //法2 递归  类似动态规划的思想
    int[] memo;

    public int coinChange2(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -666);
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != -666) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }
}

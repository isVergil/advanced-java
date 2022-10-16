package com.algorithm.leetcode;

import java.util.Arrays;

/**
 * @ClassName LC322
 * @Description TODO
 * @Author bill
 * @Date 2022/7/8 10:35
 * @Version 1.0
 **/
public class LC322 {

    static int[] memo;

    public static int change(int amount, int[] coins) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return dfs(0, amount, coins);
    }

    static int dfs(int idx, int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        if (idx == coins.length || amount < 0) {
            return 0;
        }
        if (memo[amount] != -1) {
            return memo[amount];
        }
        int ans = 0;
        for (int i = idx; i < coins.length; i++) {
            ans += dfs(i, amount - coins[i], coins);
        }
        return memo[amount] = ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        change(5, nums);
        System.out.println(1);
    }
}

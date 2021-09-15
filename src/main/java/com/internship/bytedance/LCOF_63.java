package com.internship.bytedance;

/**
 * @ClassName LCOF_63
 * @Description TODO
 * @Author bill
 * @Date 2021/9/15 21:40
 * @Version 1.0
 **/
/*
 股票的最大利润
 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
public class LCOF_63 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int min = prices[0];
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            result = Math.max(prices[i] - min, result);
        }
        return result;
    }

    //法2 动态规划
    //dp[i] 表示前 i 天所获取的最大利润
    //状态方程： dp[i] = Math.max(dp[i-1],prices[i] - min);
    //前i日最大利润=max(前(i−1)日最大利润,第i日价格−前i日最低价格)
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        //dp[i] 表示前 i 天所获取的最大利润
        int[] dp = new int[prices.length];
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i - 1]);
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }
        return dp[prices.length - 1];
    }
}

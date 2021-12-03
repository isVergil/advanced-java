package com.internship.bytedance;

/**
 * @ClassName LC_474
 * @Description TODO
 * @Author bill
 * @Date 2021/9/6 20:35
 * @Version 1.0
 **/
public class LC_474 {
    //一和零
    public int findMaxForm(String[] strs, int m, int n) {
        //最多有i个0和j个1的strs的最⼤⼦集的⼤⼩为dp[i][j]。
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeroCount = 0, oneCount = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
            //装包
            for (int i = m; i >= zeroCount; i--) {
                for (int j = n; j >= oneCount; j--) {
                    //dp[i][j] 可以由前一个strs里的字符串推导出来，strs里的字符串有zeroNum个0，oneNum个1。
                    //dp[i][j] 就可以是 dp[i - zeroNum][j - oneNum] + 1。
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroCount][j - oneCount] + 1);
                }
            }
        }
        return dp[m][n];
    }
}

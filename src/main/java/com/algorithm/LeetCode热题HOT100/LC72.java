package com.algorithm.LeetCode热题HOT100;

/**
 * @ClassName LC72
 * @Description 72. 编辑距离
 * @Author bill
 * @Date 2022/3/25 13:23
 * @Version 1.0
 **/
public class LC72 {

    //dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。
    //以 word1 为 "horse"，word2 为 "ros"，且 dp[5][3] 为例，即要将 word1的前 5 个字符转换为 word2的前 3 个字符，也就是将 horse 转换为 ros，因此有：
    //(1) dp[i-1][j-1]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 2 个字符 ro，然后将第五个字符 word1[4]（因为下标基数以 0 开始） 由 e 替换为 s（即替换为 word2 的第三个字符，word2[2]）
    //(2) dp[i][j-1]，即先将 word1 的前 5 个字符 horse 转换为 word2 的前 2 个字符 ro，然后在末尾补充一个 s，即插入操作
    //(3) dp[i-1][j]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 3 个字符 ros，然后删除 word1 的第 5 个字符
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            if (word1 == null && word2 == null) {
                return 0;
            }
            return word1 == null ? word2.length() : word1.length();
        }
        int rows = word1.length();
        int cols = word2.length();
        int[][] dp = new int[rows + 1][cols + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= rows; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i <= cols; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
                if (word1.charAt(row - 1) == word2.charAt(col - 1)) {
                    dp[row][col] = dp[row - 1][col - 1];
                    continue;
                }
                dp[row][col] = Math.min(Math.min(dp[row - 1][col - 1], dp[row - 1][col]), dp[row][col - 1]) + 1;
            }
        }
        return dp[rows][cols];
    }
}

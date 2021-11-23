package com.algorithm.LeetCode热题HOT100;

import java.util.Arrays;

/**
 * @ClassName LC5
 * @Description TODO
 * @Author bill
 * @Date 2021/10/29 16:07
 * @Version 1.0
 **/
//最长回文子串  返回这个最长的子串
public class LC5 {

    //法1 动态规划
    //dp[i,j] 是否是回文串
    //dp[i,j] = (s[i] == [j] && dp[i+1][j-1]);
    public String longestPalindrome1(String s) {
        if(s.length() <= 1){
            return s;
        }
        int len = s.length();
        String res = s.substring(0,1);
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int right = 1; right < len; right++) {
            for (int left = 0; left < right; left++) {
                //字符串两端不等 就不是子串了
                if (s.charAt(left) != s.charAt(right)) {
                    dp[left][right] = false;
                    continue;
                }
                if (left + 1 >= right - 1) {   //两个相等字符的情况
                    dp[left][right] = true;
                } else {                       //大于两个字符的情况
                    dp[left][right] = dp[left + 1][right - 1];
                }
                //更新结果
                if (dp[left][right] && (right - left + 1) > res.length()) {
                    res = s.substring(left, right + 1);
                }
            }
        }
        return res;
    }
}

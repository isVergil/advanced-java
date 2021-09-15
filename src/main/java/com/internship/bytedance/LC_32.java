package com.internship.bytedance;

/**
 * @ClassName LC_32
 * @Description TODO
 * @Author bill
 * @Date 2021/9/14 14:45
 * @Version 1.0
 **/
/*
最长有效括号

给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class LC_32 {

    //法1 动态规划
    //dp[i]表示 以 i 字符结尾的最长有效括号的长度
    //1、s[i] == '(';  dp[i] = 0;
    //2、形如 "()";   dp[i] = dp[i−1] + 2;
    //3、形如 "()((****))";   dp[i] = dp[i−1] + dp[i−dp[i−1]−2] + 2;
    public int longestValidParentheses1(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2;
                    if (i - 2 >= 0) {
                        dp[i] = dp[i] + dp[i - 2];
                    }
                } else if (dp[i - 1] > 0) {
                    if ((i - dp[i - 1] - 1) >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if ((i - dp[i - 1] - 2) >= 0) {
                            dp[i] = dp[i] + dp[i - dp[i - 1] - 2];
                        }
                    }
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    //法2 正向逆向结合法
    //看官方题解视频 https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
    //从左往右遍历记录左右括号的个数，若相等 则 maxlength = 个数 * 2;  若右括号个数多 则说明被分割 个数清零 重新计算
    //从右往左遍历记录左右括号的个数，若相等 则 maxlength = 个数 * 2;  若左括号个数多 则说明被分割 个数清零 重新计算
    public int longestValidParentheses2(String s) {
        int maxLen = 0;
        char[] sArr = s.toCharArray();
        int left = 0, right = 0;
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (right == left) {
                maxLen = Math.max(left * 2, maxLen);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = sArr.length - 1; i >= 0; i--) {
            if (sArr[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (right == left) {
                maxLen = Math.max(left * 2, maxLen);
            } else if (right < left) {
                left = right = 0;
            }
        }
        return maxLen;
    }
}

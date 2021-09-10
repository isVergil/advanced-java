package com.algorithm.leetcode;

/**
 * @ClassName LC_647
 * @Description TODO
 * @Author bill
 * @Date 2021/9/6 21:12
 * @Version 1.0
 **/
//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
//具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
public class LC_647 {

    //法1 动态规划
    public int countSubstrings1(String s) {
        //dp 表示 [i,j] 是否是回文
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                //1、1个字符是回文
                //2、3个字符 当头尾相等时也是回文
                //3、大于三个字符 （头尾相等&&减去头尾是回文） 则是回文串
                if (s.charAt(i) == s.charAt(j) && ((j - i < 2) || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }

    //法2 中心扩展法
    //一个字符往外 奇数中心点 s.length() 个
    //二个字符往外 偶数中心点 s.length() - 1 个
    public int countSubstrings2(String s) {
        int ans = 0;
        for (int center = 0; center < 2 * s.length() - 1; center++) {
            //保证遍历到所有的中心点情况
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }


}

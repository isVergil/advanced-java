package com.algorithm.leetcode;

/**
 * @ClassName LC_5
 * @Description TODO
 * @Author bill
 * @Date 2021/9/6 21:40
 * @Version 1.0
 **/
//最长回文子串
public class LC_5 {
    //1、中心拓展法 参考 LC_647
    public String longestPalindrome(String s) {
        int max = 0, startIndex = 0;
        for (int i = 0; i < s.length() * 2 - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                int temp = right - left + 1;
                if (temp >= max) {
                    max = temp;
                    startIndex = left;
                }
                left--;
                right++;
            }
        }
        return s.substring(startIndex, startIndex + max);
    }
}

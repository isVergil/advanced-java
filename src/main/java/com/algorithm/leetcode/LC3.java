package com.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LC3
 * @Description TODO
 * @Author bill
 * @Date 2021/8/16 15:00
 * @Version 1.0
 **/
public class LC3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abca"));
    }

    public static int lengthOfLongestSubstring(String s) {
        //字符长度
        int n = s.length();
        if (n <= 1) return n;
        int maxLen = 1;
        int left = 0, right = 0;
        int[] window = new int[128];
        while (right < n) {
            char rightChar = s.charAt(right);
            int rightCharIndex = window[rightChar];
            left = Math.max(left, rightCharIndex);
            maxLen = Math.max(maxLen, right - left + 1);
            window[rightChar] = right + 1;
            right++;
        }
        return maxLen;
    }

    //滑动窗口
    public int lengthOfLongestSubstring1(String s) {
        int length = s.length();
        char[] ch = s.toCharArray();
        int left = 0, right = 0, result = 0;
        Set<Character> sets = new HashSet<>();
        while (right < length) {
            if (sets.contains(ch[right])) {
                sets.remove(ch[left++]);
            } else {
                sets.add(ch[right++]);
                result = Math.max(result, right - left);
            }
        }
        return result;
    }

}

package com.algorithm.剑指offer;


import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName JZ48
 * @Description TODO
 * @Author bill
 * @Date 2021/9/16 15:40
 * @Version 1.0
 **/
/*
 最长不含重复字符的子字符串

 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class JZ48 {
    //法1
    //滑动窗口 set 去重
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, sLength = s.length();
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        while (left < sLength && right < sLength) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            } else {
                set.add(s.charAt(right++));
                maxLength = Math.max(maxLength, right - left);
            }
        }
        return maxLength;
    }
}

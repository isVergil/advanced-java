package com.algorithm.LeetCode热题HOT100;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LC3
 * @Description TODO
 * @Author bill
 * @Date 2021/10/28 21:10
 * @Version 1.0
 **/
/*
无重复字符的最长子串
左右指针 包裹的就是不重复的子串
滑动窗口
set 去除重复 去重
 */
public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        char[] sArray = s.toCharArray();
        int result = 0, left = 0, right = 0, len = sArray.length;
        Set<Character> set = new HashSet<>();
        while (right < len) {
            if (set.contains(sArray[right])) {
                set.remove(sArray[left++]);
            } else {
                set.add(sArray[right++]);
                result = Math.max(result, right - left);
            }
        }
        return result;
    }
}

package com.algorithm.剑指offer;


import java.util.HashMap;
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
        while (right < sLength) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            } else {
                set.add(s.charAt(right++));
                maxLength = Math.max(maxLength, right - left);
            }
        }
        return maxLength;
    }

    //法2  哈希表
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap();
        int res = 0, tempRes = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = map.getOrDefault(s.charAt(i), -1);
            map.put(s.charAt(i), i);
            tempRes = tempRes < i - j ? tempRes + 1 : i - j;
            res = Math.max(tempRes, res);
        }
        return res;
    }

    //法3  类似 hash表
    public int lengthOfLongestSubstring3(String s) {
        int[] dic = new int[128];
        int res = 0, curDic = 0;
        for (int i = 0; i < s.length(); i++) {
            //获取当前字符的旧位置
            curDic = Math.max(dic[s.charAt(i)], curDic);
            //计算最大长度
            res = Math.max(res, i - curDic + 1);
            //更新当前当前字符的最新位置
            dic[s.charAt(i)] = i + 1;
        }
        return res;
    }
}

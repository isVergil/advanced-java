package com.algorithm.leetcode;

import java.util.*;

/**
 * @ClassName LC763
 * @Description 763. 划分字母区间
 * @Author bill
 * @Date 2022/4/6 14:14
 * @Version 1.0
 **/
public class LC763 {

    /**
     * @author bill
     * @description  字节实习（一面）
     * @updateTime 2022/4/6  14:27
     */
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList();
        int end = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(last[s.charAt(i) - 'a'], end);
            if (end == i) {
                res.add(i - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}

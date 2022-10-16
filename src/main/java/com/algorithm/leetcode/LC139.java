package com.algorithm.leetcode;

import java.util.List;

/**
 * @ClassName LC139
 * @Description 139. 单词拆分
 * @Author bill
 * @Date 2022/5/21 21:37
 * @Version 1.0
 **/
public class LC139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        // 可以类比于背包问题
        int n = s.length();
        // memo[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分
        boolean[] memo = new boolean[n + 1];
        //memo[0] 代表空串，处理边界问题。想象下这样的case: s = "abc", wordDict = ["abc"]
        memo[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }

}

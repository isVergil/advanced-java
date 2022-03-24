package com.algorithm.LeetCode热题HOT100;

/**
 * @ClassName LC10
 * @Description 正则表达式匹配
 * @Author bill
 * @Date 2022/3/17 14:02
 * @Version 1.0
 **/
public class LC10 {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        //p第二个字符为 *
        if (p.length() >= 2 && p.charAt(1) == '*') {
            //p[0] 出现 0 次
            boolean tmp0 = isMatch(s, p.substring(2));
            //p[0] 出现 多次 前提是 firstMatch
            boolean tmpN = firstMatch && isMatch(s.substring(1), p);
            return tmp0 || tmpN;
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}

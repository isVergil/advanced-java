package com.algorithm.剑指offer;


/**
 * @ClassName JZ13
 * @Description TODO
 * @Author bill
 * @Date 2021/8/30 15:31
 * @Version 1.0
 **/

/*
正则表达式匹配

请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。

 */
public class JZ19 {

    //法1：递归
    public boolean isMatch(String s, String p) {
        //1：p为空
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        //2：p不为空
        //2.1：首字符是否匹配  s[i] == p[i] || p[i] == '.'
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        //*出现在第二个位置  前面元素重复 n 次  或者 0 次
        //2.1.1： * 出现在第二个位置 有以下两种情况
        //2.1.1.1： 前一个元素出现 0 次         s不变 p去除前面两个字符   isMatch(s, p.substring(2)                      |    s="bc"   p="a*bc"
        //2.1.1.2： 前一个元素出现 1 次 或 多次  p不变 s去除前面一个字符   firstMatch && isMatch(s.substring(1), p)       |    s="abc"  p="a*bc"
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (firstMatch && isMatch(s.substring(1), p)) || isMatch(s, p.substring(2));
            //2.1.2： 一般情况 s p 首字符都相等 同时减去首字符 继续匹配
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }


    //法2：动态规划 （最优子结构）
    //注意 "" 和 "." 或者 "*" 都不匹配  因此 dp[0][1] 一定为 false
    public boolean isMatch1(String s, String p) {
        //dp[i][j] 表示 s 的前 i 个字符 和 p 的前 i 个字符 是否匹配
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        //初始化 s,p 都为空 为 true
        dp[0][0] = true;
        //s 为空，p 不为空的情况      |  s=""   p="a*b*"
        for (int j = 2; j <= p.length(); j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i + 1][j - 1] || isfirstMatch(s, p, i, j - 1) && dp[i][j + 1];
                } else {
                    dp[i + 1][j + 1] = isfirstMatch(s, p, i, j) && dp[i][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    boolean isfirstMatch(String s, String p, int i, int j) {
        return s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
    }


}

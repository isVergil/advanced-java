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

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JZ19 {

    public static void main(String[] args) {

    }

    //法1：递归
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        //首字符是否匹配
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        //*出现在第二个位置  前面元素重复 n 次  或者 0 次
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (firstMatch && isMatch(s.substring(1), p)) || isMatch(s, p.substring(2));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

}

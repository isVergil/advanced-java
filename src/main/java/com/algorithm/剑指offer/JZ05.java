package com.algorithm.剑指offer;

/*
替换空格

请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

来源：力扣（LeetCode）
https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JZ05 {
    public static void main(String[] args) {

    }

    public String replaceSpace(String s) {
        if (s == null) {
            return s;
        }
        char[] sArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : sArray) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

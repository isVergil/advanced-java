package com.internship.bytedance;

import java.util.Stack;

/**
 * @ClassName LCOF_58_1
 * @Description TODO
 * @Author bill
 * @Date 2021/9/6 17:01
 * @Version 1.0
 **/
public class LCOF_58_1 {
    public String reverseWords(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        s = s.trim();
        char[] sArray = s.toCharArray();
        int i = 0, j = 0, len = s.length();
        Stack<String> stack = new Stack<>();
        while (i < len) {
            //找到第一个空格
            while (i < len && sArray[i] != ' ') {
                i++;
            }
            stack.add(s.substring(j, i) + " ");
            //继续右移遍历完当前空格
            while (i < len && sArray[i] == ' ') {
                i++;
            }
            j = i;
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString().trim();
    }
}

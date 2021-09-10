package com.algorithm.剑指offer;

import java.util.Stack;

/**
 * @ClassName JZ58_1
 * @Description TODO
 * @Author bill
 * @Date 2021/9/6 16:45
 * @Version 1.0
 **/
public class JZ58_1 {
    public String reverseWords(String s) {
        //去除前后空格
        s = s.trim();
        char[] sArray = s.toCharArray();
        Stack<String> stack = new Stack<>();
        int i = 0, j = 0, len = sArray.length;
        while (i < len) {
            //遍历到首个空格
            while (i < len && sArray[i] != ' ') {
                i++;
            }
            stack.push(s.substring(j, i) + " ");
            //遍历到空格之后的首个字符
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

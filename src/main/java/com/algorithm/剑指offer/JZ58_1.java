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

    public String reverseWords1(String s) {
        String[] strs = s.trim().split(" "); // 删除首尾空格，分割字符串
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if (strs[i].equals("")) continue; // 遇到空单词则跳过
            res.append(strs[i] + " "); // 将单词拼接至 StringBuilder
        }
        return res.toString().trim(); // 转化为字符串，删除尾部空格，并返回
    }

    public static void main(String[] args) {
        System.out.println(new JZ58_1().reverseWords1("12  34 5 6  7 8"));

    }

}

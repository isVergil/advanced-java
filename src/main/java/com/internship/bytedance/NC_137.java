package com.internship.bytedance;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName NC_137
 * @Description TODO
 * @Author bill
 * @Date 2021/9/8 10:53
 * @Version 1.0
 **/
/*
中缀表达式求值
 */
public class NC_137 {

    //操作符优先级
    Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('-', 1);
        put('+', 1);
        put('*', 2);
        put('/', 2);
        put('%', 2);
        put('^', 3);
    }};

    public int solve(String s) {
        s = s.replaceAll(" ", "");     //去掉空格
        char[] cs = s.toCharArray();
        int n = s.length();
        Stack<Integer> nums = new Stack<>();           //存数字
        nums.push(0);                            //防止 第一个数是负数
        Stack<Character> ops = new Stack<>();         // 存放所有「非数字以外」的操作
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') {                    //括号优先级最高 先判断
                ops.push(c);
            } else if (c == ')') {             //遇到回括号  计算到最近一个左括号为止
                while (!ops.isEmpty()) {
                    if (ops.peek() != '(') {
                        calc(nums, ops);
                    } else {
                        ops.pop();             // '(' 弹出
                        break;
                    }
                }
            } else {  //其他非括号的情况  数字入数字栈  运算符入运算符栈（并且按照优先级计算）
                if (Character.isDigit(c)) {   //如果是数字就直接入数字栈，注意不是单个数字字符，是整个连续的整数
                    int num = 0, j = i;
                    while (j < n && Character.isDigit(cs[j])) {       //获取连续的整数数字 并 入 nums 栈
                        num = num * 10 + (cs[j++] - '0');
                    }
                    nums.push(num);
                    i = j - 1;                         //i 此时遍历到了 j - 1
                } else {      //运算符入栈
                    //if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                    //if (i > 0 && (cs[i - 1] == '(')) {
                    if ((cs[i - 1] == '(') && (cs[i] == '-')) {
                        nums.push(0);
                    }
                    // 有一个新操作要入栈时，先把栈内可以算的都算了
                    // 只有满足「栈内运算符」比「当前运算符」优先级高/同等，才进行运算
                    while (!ops.isEmpty() && ops.peek() != '(') {
                        char prev = ops.peek();
                        if (map.get(prev) >= map.get(c)) {
                            calc(nums, ops);
                        } else {
                            break;
                        }
                    }
                    ops.push(c);
                }
            }
        }
        // 将剩余的计算完
        while (!ops.isEmpty()) {
            calc(nums, ops);
        }
        return nums.peek();
    }

    void calc(Stack<Integer> nums, Stack<Character> ops) {
        //nums.size() < 2 表示已经计算完成，nums 只剩结果
        if (nums.isEmpty() || nums.size() < 2 || ops.isEmpty()) {
            return;
        }
        int b = nums.pop(), a = nums.pop();
        char op = ops.pop();
        int ans = 0;
        if (op == '+') {
            ans = a + b;
        } else if (op == '-') {
            ans = a - b;
        } else if (op == '*') {
            ans = a * b;
        } else if (op == '/') {
            ans = a / b;
        } else if (op == '^') {
            ans = (int) Math.pow(a, b);
        } else if (op == '%') {
            ans = a % b;
        }
        nums.push(ans);
    }
}

package com.algorithm.剑指offer;


/*
斐波那契数列

写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：

https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class JZ10_1 {
    public static void main(String[] args) {

    }

    public int fib(int n) {
        if (n <= 1)
            return n;
        int f0 = 0, f1 = 1;
        int result = 0;
        while (--n > 0) {
            result = (f0 + f1) % 1000000007;
            f0 = f1;
            f1 = result;
        }
        return result;
    }

}

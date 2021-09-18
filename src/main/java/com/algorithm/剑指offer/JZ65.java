package com.algorithm.剑指offer;

/**
 * @ClassName JZ65
 * @Description TODO
 * @Author bill
 * @Date 2021/9/18 16:26
 * @Version 1.0
 **/
/*
不用加减乘除做加法

写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。

加法结果 = 不带进位的 + 只考虑进位结果的
异或也叫半加运算，其运算法则相当于不带进位的二进制加法:不同为1 相同为0  ：1^1=0  1^0=1
 */
public class JZ65 {
    //1、递归
    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        int newA = a ^ b;
        int newB = (a & b) << 1;
        return add(newA, newB);
    }

    //2、非递归
    public int add1(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}

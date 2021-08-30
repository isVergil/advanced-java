package com.algorithm.剑指offer;

/**
 * @ClassName JZ13
 * @Description TODO
 * @Author bill
 * @Date 2021/8/30 15:31
 * @Version 1.0
 **/

/*
数值的整数次方

实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。

https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 */
public class JZ16 {

    public static void main(String[] args) {

    }


    //O(n) 会超时
    public double myPow1(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        double result = x;
        if (n < 0) {
            n *= (-1);
            x = 1 / x;
            result = x;
        }
        while ((--n) > 0) {
            result *= x;
        }
        return result;
    }

    //O(logn)
    public double myPow2(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}

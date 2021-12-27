package com.algorithm.剑指offer;

/**
 * @ClassName JZ43
 * @Description TODO
 * @Author bill
 * @Date 2021/12/2 10:18
 * @Version 1.0
 **/
/*
整数中1出现的次数（从1到n整数中1出现的次数）
 */
public class JZ43 {
    //3种情况
    //1、cur == 0 :  high * digit;
    //2、cur == 1 :  high * digit + low + 1
    //3、else     :  (high + 1) * digit
    public int NumberOf1Between1AndN_Solution(int n) {
        int res = 0;
        int digit = 1;
        int high = n / 10, cur = n % 10, low = 0;
        //cur != 0 是考虑只有一个数的问题
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += (high * digit + low + 1);
            } else {
                res += (high + 1) * digit;
            }
            low += (cur * digit);
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}

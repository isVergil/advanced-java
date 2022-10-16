package com.test;

/**
 * @ClassName Test222
 * @Description TODO
 * @Author bill
 * @Date 2022/9/15 11:19
 * @Version 1.0
 **/
public class Test222 {

    //4 2
    //5 2
    public static void main(String[] args) {
        System.out.println(sqrt(4));
        System.out.println(sqrt(5));
    }

    static long sqrt(long n) {
        long l = 0, r = n;
        long res = l;
        while (l < r) {
            long mid = (l + r) >> 1;
            if (mid * mid > n) {
                r = mid - 1;
            } else {
                l = mid;
                res = Math.max(res, l);
            }
        }
        return res;
    }
}

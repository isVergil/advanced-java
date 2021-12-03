package com.algorithm.剑指offer;

/**
 * @ClassName JZ64
 * @Description TODO
 * @Author bill
 * @Date 2021/11/28 20:06
 * @Version 1.0
 **/
/*
   求1+2+3+...+n
 */
public class JZ64 {

    //短路法
    public int Sum_Solution1(int n) {
        boolean tmp = (n > 1) && (n += Sum_Solution1(n - 1)) > 0;
        return n;
    }

    //异常法
    int[] res = new int[]{0};

    public int Sum_Solution(int n) {
        try {
            return res[n];
        } catch (Exception e) {
            return n + Sum_Solution(n - 1);
        }
    }
}

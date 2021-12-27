package com.algorithm.剑指offer;

/**
 * @ClassName JZ70
 * @Description TODO
 * @Author bill
 * @Date 2021/12/20 16:03
 * @Version 1.0
 **/
/*
矩形覆盖
 */
public class JZ70 {
    //f(n) = f(n - 1) + f(n - 2)
    //在f(n - 2)的情况下添加一个竖着的矩形 + 在f(n - 1)的情况下添加两个横着的矩形
    public int rectCover(int target) {
        //f0 = 0, f1 = 1, f2 = 2
        if (target <= 2) {
            return target;
        }
        int f0 = 0 , f1 = 1, res = 0;
        while ((target--) >= 1) {
            res = f0 + f1;
            f0 = f1;
            f1 = res;
        }
        return res;
    }
}

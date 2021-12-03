package com.algorithm.剑指offer;

/**
 * @ClassName JZ66
 * @Description TODO
 * @Author bill
 * @Date 2021/9/18 16:03
 * @Version 1.0
 **/
/*
 构建乘积数组

 返回所有数组元素乘积的结果集，不能使用除法
 */
public class JZ66 {
    //画图就行
    //法1 两次 for 循环 分别计算上三角和下三角的乘积
    //考虑一个 n*n 的矩阵
    //第一次从 统计 下三角乘积的和
    //第二次从 统计 上三角乘积的和
    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len == 0) {
            return new int[0];
        }
        int[] res = new int[len];
        res[0] = 1;
        int temp = 1;
        //下三角的乘积   从下往上
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }
        //再加上 上三角的乘积   从上往下
        for (int i = len - 2; i >= 0; i--) {
            temp *= a[i + 1];
            res[i] *= temp;
        }
        return res;
    }

    //法2 内外 for 循环
    //外循环剔除一个元素，内循环计算乘积
    //O(n^2) 超时
    public int[] constructArr1(int[] a) {
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int temp = 1;
            for (int j = 0; j < a.length; j++) {
                if (i != j) {
                    temp *= a[j];
                }
            }
            res[i] = temp;
        }
        return res;
    }
}

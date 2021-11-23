package com.algorithm.剑指offer;

/**
 * @ClassName JZ49
 * @Description TODO
 * @Author bill
 * @Date 2021/10/27 10:21
 * @Version 1.0
 **/
/*
丑数  ：之前的丑数 * 2 或 * 3 或 * 5 的按照大小排列的数列
 *2 序列    *3 序列    *5 序列
  2 * 1     3 * 1      5 * 1     取最小 a[1] = 2
  2 * 2     3 * 1      5 * 1     取最小 a[2] = 3
  2 * 2     3 * 2      5 * 1     取最小 a[3] = 4
  2 * 3     3 * 2      5 * 1     取最小 a[4] = 5
 */
public class JZ49 {
    public int nthUglyNumber(int n) {
        int[] a = new int[n];
        a[0] = 1;
        int index2 = 0;    //遍历丑数 * 2 的队列
        int index3 = 0;    //遍历丑数 * 3 的队列
        int index5 = 0;    //遍历丑数 * 5 的队列
        for (int i = 0; i < n; i++) {
            a[i] = Math.min(Math.min(a[index2] * 2, a[index3] * 3), a[index5] * 5);
            if (a[i] == a[index2] * 2) {
                index2++;
            }
            if (a[i] == a[index3] * 3) {
                index3++;
            }
            if (a[i] == a[index5] * 5) {
                index5++;
            }
        }
        return a[n - 1];
    }
}

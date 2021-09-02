package com.algorithm.剑指offer;


/**
 * @ClassName JZ13
 * @Description TODO
 * @Author bill
 * @Date 2021/8/30 15:31
 * @Version 1.0
 **/

/*
顺时针打印矩阵


 */
public class JZ29 {

    public static void main(String[] args) {


    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[t][i]; // 左 到 右
            }
            //换下一行
            if (++t > b) {
                break;
            }
            for (int i = t; i <= b; i++) {
                res[x++] = matrix[i][r]; // 上 到 下
            }
            //换下一列
            if (l > --r) {
                break;
            }
            for (int i = r; i >= l; i--) {
                res[x++] = matrix[b][i]; // 右 到 左
            }
            //换下一行
            if (t > --b) {
                break;
            }
            for (int i = b; i >= t; i--) {
                res[x++] = matrix[i][l]; // bottom to top.
            }
            //换下一列
            if (++l > r) {
                break;
            }
        }
        return res;
    }

}

package com.internship.bytedance;

/**
 * @ClassName LC_01_07
 * @Description TODO
 * @Author bill
 * @Date 2021/9/16 14:18
 * @Version 1.0
 **/
public class LC_01_07 {

    //法1 辅助数组
    //1、新建一个大小一样的空数组  newMatrix
    //2、matrix 的行数组 作为 newMatrix的列数组  即 newMatrix[col][n - row - 1] = matrix[row][col];
    //3、最后赋值即可 matrix[row][col] = newMatrix[row][col];
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        int[][] newMatrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                newMatrix[col][n - row - 1] = matrix[row][col];
            }
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = newMatrix[row][col];
            }
        }
    }

    //法2 多次翻转
    //1、水平翻转      matrix[row][col] = matrix[n−row−1][col];
    //2、主对角线翻转   matrix[row][col] = matrix[col][row];
    //注意循环的上下界
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        //水平翻转
        for (int row = 0; row < n / 2; row++) {
            for (int col = 0; col < n; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[n - row - 1][col];
                matrix[n - row - 1][col] = temp;
            }
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < row; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }


}

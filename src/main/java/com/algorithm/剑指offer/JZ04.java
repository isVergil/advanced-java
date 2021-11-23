package com.algorithm.剑指offer;


/*
二维数组中的查找

在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

 */
public class JZ04 {

    //方法1 从左下找 小的往上，大的往右
    //O(m+n)  O(1)
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rowCount = matrix.length - 1;
        int colCount = matrix[0].length - 1;
        int row = rowCount;
        int col = 0;
        while (row >= 0 && col <= colCount) {
            if (matrix[row][col] == target) {
                return true;
            }
            //往上找
            if (matrix[row][col] > target) {
                row--;
            } else {  //往右找
                col++;
            }
        }
        return false;
    }

    //自写
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        //从左下找 比大右移 比小左移
        int m = matrix.length - 1;
        int n = 0;
        while (m >= 0 && n < matrix[0].length) {
            if (target == matrix[m][n]) {
                return true;
            } else if (target < matrix[m][n]) {
                m--;
            } else {
                n++;
            }
        }
        return false;
    }
}

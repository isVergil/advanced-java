package com.algorithm.剑指offer;

/**
 * @ClassName JZ47
 * @Description TODO
 * @Author bill
 * @Date 2021/11/22 15:11
 * @Version 1.0
 **/
/*
 礼物的最大价值
 */
public class JZ47 {
    //动态规划
    //grid[i][j] 表示 到 grid[i][j] 的路径最大值
    public int maxValue(int[][] grid) {
        //纵向
        for (int i = 0; i < grid.length; i++) {
            //横向
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {  //第一行
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {  //第一列
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}

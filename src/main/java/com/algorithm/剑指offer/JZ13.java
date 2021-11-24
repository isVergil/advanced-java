package com.algorithm.剑指offer;

/**
 * @ClassName JZ13
 * @Description TODO
 * @Author bill
 * @Date 2021/8/30 15:31
 * @Version 1.0
 **/

/*
机器人的运动范围

地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

 */
public class JZ13 {
    //法1 回溯 + dfs
    int m, n, k;
    int res = 0;
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];
        return dfs(0, 0);
    }

    int dfs(int m, int n) {
        if (m >= this.m || m < 0 || n >= this.n || n < 0 || cal(m) + cal(n) > k || visited[m][n]) {
            return 0;
        }
        visited[m][n] = true;
        return dfs(m - 1, n) + dfs(m + 1, n) + dfs(m, n - 1) + dfs(m, n + 1) + 1;
    }

    int cal(int num) {
        if (num < 10) {
            return num;
        }
        int count = 0;
        while (num > 0) {
            count += num % 10;
            num /= 10;
        }
        return count;
    }

    //法2 bfs
}

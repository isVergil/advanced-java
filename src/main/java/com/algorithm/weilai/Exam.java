package com.algorithm.weilai;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @ClassName Exam
 * @Description TODO
 * @Author bill
 * @Date 2022/7/15 20:22
 * @Version 1.0
 **/
public class Exam {

    //最大子方阵
    //public static void main(String[] args) {
    //    Scanner sc = new Scanner(System.in);
    //    int n = sc.nextInt();
    //    int m = sc.nextInt();
    //    int[][] arr = new int[n][m];
    //    for (int i = 0; i < n; i++) {
    //        for (int j = 0; j < m; j++) {
    //            arr[i][j] = sc.nextInt();
    //        }
    //    }
    //    int res = 0;
    //    for (int r = 0; r < n - 1; r++) {
    //        for (int c = 0; c < m - 1; c++) {
    //            int leap = 1;
    //            while (r + leap < n && c + leap < m) {
    //                res = Math.max(arr[r][c] + arr[r + leap][c] + arr[r + leap][c + leap] + arr[r][c + leap], res);
    //                leap++;
    //            }
    //        }
    //    }
    //    System.out.println(res);
    //}

    //最少操作次数
    //public static void main(String[] args) {
    //    Scanner sc = new Scanner(System.in);
    //    int x = sc.nextInt();
    //    int y = sc.nextInt();
    //    int a = sc.nextInt();
    //    int b = sc.nextInt();
    //    if (a == b) {
    //        System.out.println(0);
    //        return;
    //    }
    //    int[] dp = new int[b + 1];
    //    Arrays.fill(dp, 1000000007);
    //    dp[0] = 0;
    //    if (a * x <= b) {
    //        dp[a * x] = 1;
    //    }
    //    if (a + y <= b) {
    //        dp[a + y] = 1;
    //    }
    //    for (int i = 0; i <= b; i++) {
    //        if (i >= y) {
    //            dp[i] = Math.min(dp[i], dp[i - y] + 1);
    //        }
    //        if (i % x == 0) {
    //            dp[i] = Math.min(dp[i], dp[i / x] + 1);
    //        }
    //    }
    //    if (dp[b] > 100000000) {
    //        System.out.println(-1);
    //    } else {
    //        System.out.println(dp[b]);
    //    }
    //}

    //static int res = Integer.MAX_VALUE;
    //
    //static void dfs(int x, int y, int count, int cur, int target) {
    //    if (cur >= target) {
    //        if (cur == target) {
    //            res = Math.min(res, count);
    //        }
    //        return;
    //    }
    //    //选择 * x
    //    dfs(x, y, count + 1, cur * x, target);
    //    //选择 + y
    //    dfs(x, y, count + 1, cur + y, target);
    //}

    //最大开心值
    //    n k
    //    5 3
    //    x y
    // 1  1 3
    // 2  2 1
    // 3  5 2
    // 4  3 1
    // 5  4 3
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] xy = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                xy[i][j] = sc.nextInt();
            }
        }
        //按照 x 花费 排序
        Arrays.sort(xy, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int l = 0, r = 0, maxY = 0;
        int curY = 0;
        while (l < n) {
            while (r < n && xy[r][0] - xy[l][0] < k) {
                curY += xy[r][1];
                r++;
            }
            maxY = Math.max(maxY, curY);
            curY -= xy[l][1];
            l++;
        }
        System.out.println(maxY);
    }
}

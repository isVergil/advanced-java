package com.autumn.huawei;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @ClassName Test0831
 * @Description TODO
 * @Author bill
 * @Date 2022/8/31 19:57
 * @Version 1.0
 **/
public class Test0831 {

    // //1
    // /*
    //  Hello world.
    //     Good Hello LOOP
    //     1 world.
    //
    //  */
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int D = sc.nextInt();
    //     int N = sc.nextInt();
    //     int[][] arr = new int[N][2];
    //     for (int i = 0; i < N; i++) {
    //         for (int j = 0; j < 4; j++) {
    //             arr[i][j] = sc.nextInt();
    //         }
    //     }
    //     if (D <= 1000) {
    //         System.out.println(D / 100);
    //         return;
    //     }
    //     //到达 dis 所需的最小时间
    //     int[] dp = new int[N + 1];
    //     int maxDis = D;
    //     for (int i = 0; i < N; i++) {
    //         int[] ar = arr[i];
    //         int dis = ar[0];
    //         int charge = ar[1];
    //         if (D >= dis) {
    //             dp[i] = dp[i - 1];
    //             D -
    //         } else {
    //
    //         }
    //
    //
    //     }

    //2 bfs
    /*
    4 4
    1 1 1 1
    1 6 2 1
    1 1 0 1
    1 3 1 1
    out 3

    8 4
    1 6 2 1
    1 1 0 1
    1 1 0 1
    1 1 0 1
    1 1 0 1
    1 1 0 1
    1 1 0 1
    1 1 3 1
    out 7
     */
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int m = sc.nextInt();
    //     int[][] arr = new int[n][m];
    //     int beginI = 0, beginJ = 0;
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < m; j++) {
    //             arr[i][j] = sc.nextInt();
    //             if (arr[i][j] == 2) {
    //                 beginI = i;
    //                 beginJ = j;
    //             }
    //         }
    //     }
    //     int[][] vis = new int[n][m];
    //     vis[beginI][beginJ] = 1;
    //     int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    //     Deque<int[]> deque = new LinkedList<>();
    //     deque.addLast(new int[]{beginI, beginJ});
    //     int step = 0, boomStep = 0;
    //     while (!deque.isEmpty()) {
    //         int size = deque.size();
    //         step++;
    //         boomStep++;
    //         while (size-- > 0) {
    //             int[] cur = deque.pollFirst();
    //             for (int[] dir : dirs) {
    //                 int ni = cur[0] + dir[0];
    //                 int nj = cur[1] + dir[1];
    //                 if (ni < 0 || ni > n || nj < 0 || nj > m || arr[ni][nj] == 1 || vis[ni][nj] == 1) {
    //                     continue;
    //                 }
    //                 //炸弹 炸四周
    //                 if (arr[ni][nj] == 6) {
    //                     for (int[] dirBoom : dirs) {
    //                         int bi = ni + dirBoom[0];
    //                         int bj = nj + dirBoom[1];
    //                         if (bi < 0 || bi > n || bj < 0 || bj > m || arr[bi][bj] == 4 || vis[bi][bj] == 1) {
    //                             continue;
    //                         }
    //                         if (arr[bi][bj] == 1) {
    //                             arr[bi][bj] = 0;
    //                         }
    //                     }
    //                 }
    //                 //陷阱
    //                 if (arr[ni][nj] == 4) {
    //                     boomStep += 3;
    //                 }
    //                 //终点
    //                 if (arr[ni][nj] == 3) {
    //                     System.out.println(Math.min(step, boomStep));
    //                     return;
    //                 }
    //                 vis[ni][nj] = 1;
    //                 deque.addLast(new int[]{ni, nj});
    //             }
    //         }
    //     }
    //     System.out.println(-1);
    //
    // }

    //3
    /*
    1500
    4
    300 2
    600 1
    1000 1
    1200 0
    out 16
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();
        int N = sc.nextInt();
        int[][] dis = new int[N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                dis[i][j] = sc.nextInt();
            }
        }
        if (D <= 1000) {
            System.out.println(D / 100);
            return;
        }
        //dp[i] 到达 i 所需的最小时间
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 1001);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                //超过续航
                if (dis[i][0] - dis[j][0] > 1000) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[j] + dis[i][1] + 1);
            }
        }
        System.out.println(dp.toString());
    }
}
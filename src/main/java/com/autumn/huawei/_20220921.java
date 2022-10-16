package com.autumn.huawei;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @ClassName _20220921
 * @Description TODO
 * @Author bill
 * @Date 2022/9/24 0:31
 * @Version 1.0
 **/
public class _20220921 {

    /***
     3 2
     S.
     ..
     ..

     9 9
     .........
     .....XXX.
     .....X.X.
     .....X.X.
     .....X.XS
     XXXXXX.XX
     .........
     .........
     .........
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] chess = new char[m][n];
        for (int i = 0; i < m; i++) {
            String cur = sc.next();
            chess[i] = cur.toCharArray();
        }
        boolean[][][] vst = new boolean[m][n][2];
        //x坐标， y坐标， s当前状态 马或兵， t总耗时
        Deque<int[]> deque = new LinkedList<>();
        vst[0][0][0] = true;
        deque.addLast(new int[]{0, 0, 0, 0});
        if (chess[0][0] == 'S') {
            deque.addLast(new int[]{0, 0, 1, 1});
            vst[0][0][1] = true;
        }
        //进队列搜索
        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int x = cur[0];
            int y = cur[1];
            int s = cur[2];
            int t = cur[3];
            int[][] dirs = s == 0 ? soldierDirs : hourseDirs;
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || chess[nx][ny] == 'X') {
                    continue;
                }
                //到达终点
                if (nx == m - 1 && ny == n - 1) {
                    System.out.println(t + 1);
                    return;
                }
                //驿站 兵边马 马变兵
                if (chess[nx][ny] == 'S') {
                    if (!vst[nx][ny][0]) {
                        vst[nx][ny][0] = true;
                        deque.addLast(new int[]{nx, ny, 0, t + (s == 0 ? 1 : 2)});
                    }
                    if (!vst[nx][ny][1]) {
                        vst[nx][ny][1] = true;
                        deque.addLast(new int[]{nx, ny, 1, t + (s == 1 ? 1 : 2)});
                    }
                } else {
                    if (!vst[nx][ny][s]) {
                        vst[nx][ny][s] = true;
                        deque.addLast(new int[]{nx, ny, s, t + 1});
                    }
                }
            }
        }

        System.out.println(-1);
    }

    //兵 走 上下左右
    static int[][] soldierDirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    //马 走 日
    static int[][] hourseDirs = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {2, -1}, {2, 1}, {1, -2}, {1, 2}};
}


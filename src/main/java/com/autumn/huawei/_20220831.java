package com.autumn.huawei;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName _20220831
 * @Description TODO
 * @Author bill
 * @Date 2022/9/23 23:52
 * @Version 1.0
 **/
public class _20220831 {

    /***
     4 4
     1 1 1 1
     1 6 2 1
     1 1 0 1
     1 3 1 1
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        path = new int[n][m];
        int[] start = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                path[i][j] = sc.nextInt();
                if (path[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        bfs(start);
    }

    static int n, m;

    static int[][] path;

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static void bfs(int[] start) {
        //起始点 染色 -1
        path[start[0]][start[1]] = -1;
        Deque<int[]> queue = new LinkedList<>();
        //行坐标 , 列坐标 , 是否爆炸 , 时间
        queue.add(new int[]{start[0], start[1], 0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            int x = cur[0];
            int y = cur[1];
            int boomed = cur[0];
            int time = cur[0];
            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                //走过的染成 -1
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || path[nx][ny] == -1) {
                    continue;
                }
                if (path[nx][ny] == 1 && boomed == 1 && check(nx, ny)) {
                    queue.addLast(new int[]{nx, ny, boomed, time + 1});
                    path[nx][nx] = -1;
                } else if (path[nx][ny] == 0) {
                    queue.addLast(new int[]{nx, ny, boomed, time + 1});
                    path[nx][nx] = -1;
                } else if (path[nx][ny] == 3) {
                    System.out.println(time + 1);
                    return;
                } else if (path[nx][ny] == 4) {
                    //陷阱 走3步
                    queue.addLast(new int[]{nx, ny, boomed, time + 3});
                    path[nx][nx] = -1;
                } else if (path[nx][ny] == 6) {
                    //陷阱 引爆炸弹
                    queue.addLast(new int[]{nx, ny, 1, time + 1});
                    path[nx][nx] = -6;
                }
            }
        }
    }

    //check 当前点是否是被炸过的路
    static boolean check(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dirs[i][0];
            int ny = y + dirs[i][1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }
            if (path[nx][ny] == -6) {
                return true;
            }
        }
        return false;
    }

}

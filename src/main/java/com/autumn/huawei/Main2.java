package com.autumn.huawei;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description TODO
 * @Author bill
 * @Date 2022/9/7 19:40
 * @Version 1.0
 **/
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int startX = -1;
        int startY = -1;
        char[][] arr = new char[M][N];
        for (int i = 0; i < M; i++) {
            char[] cur = sc.next().toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = cur[j];
                if (arr[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
            }
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[3] - b[3]));
        for (int i = 0; i < 4; i++) {
            int nx = startX + dirs[i][0];
            int ny = startY + dirs[i][1];
            if (nx < 0 || ny < 0 || nx >= M || ny >= N || arr[nx][ny] == 'X' || arr[nx][ny] == '0') {
                continue;
            }
            q.add(new int[]{nx, ny, i, 1});
            arr[nx][ny] = '0';
        }
        arr[startX][startY] = '0';
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];
            int t = cur[3];
            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                if (nx < 0 || ny < 0 || nx >= M || ny >= N || arr[nx][ny] == 'X' || arr[nx][ny] == '0') {
                    continue;
                }
                int curT = d == i ? t + 1 : t + 2;
                if (arr[nx][ny] == 'E') {
                    System.out.println(curT);
                    return;
                }
                q.add(new int[]{nx, ny, i, curT});
                arr[nx][ny] = '0';
            }
        }
        System.out.println(-1);

    }


}

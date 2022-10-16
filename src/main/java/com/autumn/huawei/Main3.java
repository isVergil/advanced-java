package com.autumn.huawei;

import java.util.*;

/**
 * @ClassName Main3
 * @Description TODO
 * @Author bill
 * @Date 2022/9/7 20:35
 * @Version 1.0
 **/
public class Main3 {

    static int m, n, sx, sy;
    static int[][] arr;
    static int[][][] pres;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        sx = sc.nextInt();
        sy = sc.nextInt();
        arr = new int[m][n];
        pres = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                pres[i][j][0] = -1;
                pres[i][j][1] = -1;
            }
        }
        List<int[]> list = bfs();
        if (list == null) {
            System.out.println("-1 -1");
        } else {

        }
    }

    static List<int[]> bfs() {
        Deque<int[]> deque = new LinkedList<>();
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        deque.addLast(new int[]{sx, sy});
        arr[sx][sy] = -1;
        int cnt = 0;
        boolean flag = false;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<int[]> res = new ArrayList<>();
            while (size-- > 0) {
                int[] arr1 = deque.pollFirst();
                int x = arr1[0];
                int y = arr1[1];
                for (int i = 0; i < 4; i++) {
                    int[] dir = dirs[i];
                    int nx = dir[0] + x;
                    int ny = dir[1] + y;
                    if (nx <= 0 || nx >= m || ny < 0 || ny >= n || arr[nx][ny] == -1 || arr[nx][ny] == 2) {
                        continue;
                    }
                    if (arr[nx][ny] == 1) {
                        if (i == 1 || i == 3) {
                            pres[nx][ny][0] = x;
                            pres[nx][ny][1] = y;
                            arr[nx][ny] = -1;
                        }
                    } else {
                        deque.addLast(new int[]{nx, ny});
                        pres[nx][ny][0] = x;
                        pres[nx][ny][1] = y;
                        arr[nx][ny] = -1;
                    }
                }
                if (flag) {
                    return res;
                }
            }
            return null;
        }
        return null;
    }
}

package com.autumn.leihuo;

import java.util.*;

/**
 * @ClassName Main3
 * @Description TODO
 * @Author bill
 * @Date 2022/9/18 20:32
 * @Version 1.0
 **/
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] res = new int[n * 4][2];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            res[idx][0] = x1;
            res[idx][1] = y1;
            idx++;
            res[idx][0] = x1;
            res[idx][1] = y2;
            idx++;
            res[idx][0] = x2;
            res[idx][1] = y1;
            idx++;
            res[idx][0] = x2;
            res[idx][1] = y2;
            idx++;
        }
        //排序
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        System.out.println(res[0][0] + " " + res[0][1]);
        for (int i = 1; i < res.length; i++) {
            if (res[i][0] == res[i - 1][0] && res[i][1] == res[i - 1][1]) {
                continue;
            }
            System.out.println(res[i][0] + " " + res[i][1]);
        }

    }
}

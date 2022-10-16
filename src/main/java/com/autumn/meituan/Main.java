package com.autumn.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Main
 * @Description TODO
 * @Author bill
 * @Date 2022/8/13 16:02
 * @Version 1.0
 **/
public class Main {


    //t1
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int t = sc.nextInt();
    //     int[] times = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         times[i] = sc.nextInt();
    //     }
    //     Arrays.sort(times);
    //     // if (times[0] < t) {  //全需要魔法
    //     //     System.out.println(n);
    //     //} else
    //     if (times[0] >= n * t) {  //不需要魔法
    //         System.out.println(0);
    //     } else {
    //         int peisong = 0;
    //         int magic = 0;
    //         if (times[0] <= t) {
    //             peisong++;
    //         } else {
    //             magic++;
    //         }
    //
    //         for (int i = 1; i < n; i++) {
    //             //必须使用魔法
    //             if (peisong * t + t > times[i]) {
    //                 magic++;
    //             } else {
    //                 peisong++;
    //             }
    //         }
    //         System.out.println(magic);
    //     }
    //
    // }

    // static int n, m, k;
    //
    // static int curStep, curClean;
    //
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     n = sc.nextInt();
    //     m = sc.nextInt();
    //     k = sc.nextInt();
    //     boolean[][] isClean = new boolean[n][m];
    //     isClean[0][0] = true;
    //     curClean = 1;
    //     String s = sc.next();
    //     dfs(0, 0, s, isClean);
    //     if (curClean == n * m) {
    //         System.out.println("Yes");
    //         System.out.println(curStep);
    //     } else {
    //         System.out.println("No");
    //         System.out.println(n * m - curClean);
    //     }
    //
    //
    // }
    //
    // static void dfs(int row, int col, String s, boolean[][] isClean) {
    //     if (s.length() == curStep || row < 0 || row >= n || col < 0 || col >= m) {
    //         return;
    //     }
    //     if (curClean == n * m) {
    //         return;
    //     }
    //     if (s.charAt(curStep) == 'S') {  //下
    //         if (!isClean[row + 1][col]) {
    //             curClean++;
    //         }
    //         curStep++;
    //         isClean[row + 1][col] = true;
    //         dfs(row + 1, col, s, isClean);
    //
    //     } else if (s.charAt(curStep) == 'W') {  //上
    //         if (!isClean[row - 1][col]) {
    //             curClean++;
    //         }
    //         curStep++;
    //         isClean[row - 1][col] = true;
    //         dfs(row - 1, col, s, isClean);
    //     } else if (s.charAt(curStep) == 'A') {  //左
    //         if (!isClean[row][col - 1]) {
    //             curClean++;
    //         }
    //         curStep++;
    //         isClean[row][col - 1] = true;
    //         dfs(row, col - 1, s, isClean);
    //     } else {                                    //右
    //         if (!isClean[row][col + 1]) {
    //             curClean++;
    //         }
    //         isClean[row][col + 1] = true;
    //         curStep++;
    //         dfs(row, col + 1, s, isClean);
    //     }
    // }

    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[] nums = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         nums[i] = sc.nextInt();
    //     }
    //
    //
    // }

    static int[][][] memo;

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        memo = new int[n][n][n];
        for (int[][] ints : memo) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
        System.out.println(dfs(0, 1, 2, nums));

    }

    static int dfs(int id1, int id2, int id3, int[] nums) {
        if (id1 >= n - 2 || id2 >= n - 1 || id3 >= n || id1 >= id2 || id2 >= id3) {
            return 0;
        }
        if (memo[id1][id2][id3] != -1) {
            return memo[id1][id2][id3];
        }
        int cur = 0;
        if ((nums[id1] - nums[id2]) == (2 * nums[id2] - nums[id3])) {
            cur++;
        }
        cur += dfs(id1, id2 + 1, id3 + 1, nums);
        cur += dfs(id1, id2, id3 + 1, nums);
        cur += dfs(id1 + 1, id2 + 1, id3 + 1, nums);
        return memo[id1][id2][id3] = cur;
    }


}

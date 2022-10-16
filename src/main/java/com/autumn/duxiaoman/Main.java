package com.autumn.duxiaoman;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description TODO
 * @Author bill
 * @Date 2022/9/15 19:00
 * @Version 1.0
 **/
public class Main {

    //5 3
    // 1 10
    // 0 4
    // 3 4
    // 4 8
    // 7 10

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int h = sc.nextInt();
        // int[] snow = new int[100002];
        // while (n-- > 0) {
        //     int l = sc.nextInt();
        //     int r = sc.nextInt();
        //     for (int i = l; i < r; i++) {
        //         snow[i]++;
        //     }
        // }
        // int res = 0;
        // for (int i = 0; i < snow.length; i++) {
        //     if (snow[i] >= h) {
        //         res++;
        //     }
        // }
        // System.out.println(res);

    }

    static void cal(String str, int n, int p) {
        if (str == null || str.length() <= 1) {
            System.out.println(0);
            return;
        }
        String tmp = "";
        String s = str.substring(0, p);
        for (int i = 0; i < n / p; i++) {
            tmp += s;
        }
        if (str.equals(tmp)) {
            System.out.println(0);
            return;
        }
        int res = 0;
        int[] sums = new int[26];
        for (int i = 0; i < n; i++) {
            int cur = str.charAt(i) - 'a';
            sums[cur]++;
            res = Math.max(sums[cur], res);
        }
        System.out.println(n - res);
    }
}

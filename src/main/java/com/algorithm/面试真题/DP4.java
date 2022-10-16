package com.algorithm.面试真题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @ClassName DP4
 * @Description TODO
 * @Author bill
 * @Date 2022/7/19 10:39
 * @Version 1.0
 **/
public class DP4 {

    //public static void main(String[] args) throws IOException {
    //    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //    String[] nS = br.readLine().split(" ");
    //    String[] mS = br.readLine().split(" ");
    //    String[] kS = br.readLine().split(" ");
    //    int x = Integer.parseInt(br.readLine());
    //    int res = 0;
    //    for (int i = 0; i < nS.length; i++) {
    //        for (int j = 0; j < mS.length; j++) {
    //            for (int k = 0; k < kS.length; k++) {
    //                if (Integer.parseInt(nS[i]) + Integer.parseInt(mS[j]) + Integer.parseInt(kS[k]) <= x) {
    //                    res++;
    //                }
    //            }
    //        }
    //    }
    //    System.out.println(res == 0 ? -1 : res);
    //}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nS = br.readLine().split(" ");
        String[] mS = br.readLine().split(" ");
        String[] kS = br.readLine().split(" ");
        int x = Integer.parseInt(br.readLine());
        int res = 0;
        int[][][][] dp = new int[nS.length + 1][mS.length + 1][kS.length + 1][x + 1];
        for (int i = 0; i <= nS.length; i++) {
            for (int j = 0; j <= mS.length; j++) {
                for (int k = 0; k <= kS.length; k++) {
                    for (int l = 0; l <= x; l++) {
                        if (l == 0) {
                            dp[i][j][k][l] = 0;
                        }
                    }
                }
            }
        }
        System.out.println(res == 0 ? -1 : res);
    }
}

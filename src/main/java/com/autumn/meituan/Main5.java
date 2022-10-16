package com.autumn.meituan;

import java.util.Scanner;

/**
 * @ClassName Main5
 * @Description TODO
 * @Author bill
 * @Date 2022/9/3 11:59
 * @Version 1.0
 **/
public class Main5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //城市数量
        int[][] dd = new int[n][n];
        for (int[] ints : dd) {
            for (int i = 0; i < ints.length; i++) {
                ints[i] = sc.nextInt();
            }
        }
        System.out.println();
    }
}

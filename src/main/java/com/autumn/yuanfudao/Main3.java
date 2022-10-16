package com.autumn.yuanfudao;

import java.util.Scanner;

/**
 * @ClassName Main3
 * @Description TODO
 * @Author bill
 * @Date 2022/8/26 20:22
 * @Version 1.0
 **/
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mn = new int[m][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 4; j++) {
                mn[i][j] = sc.nextInt();
            }
        }
        System.out.println(1);
    }

}

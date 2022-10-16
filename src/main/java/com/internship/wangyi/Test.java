package com.internship.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Test
 * @Description TODO
 * @Author bill
 * @Date 2022/4/21 19:11
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int len = 2 * n - 1;
        char[][] c = new char[len][len];
        for (int row = 0; row < n; row++) {
            c[row][0] = '*';
            if (row == 0) {
                Arrays.fill(c[0], '*');
                int col = 1;
                while (col < n) {
                    c[0][col++] = ' ';
                }
            }
            c[row][row] = '*';
            c[row][n - 1] = '*';
            c[row][len - 1 - row] = '*';
            if (row == n - 1) {
                for (int col = 0; col < len; col++) {
                    c[row][col] = '*';
                }
            }
        }
        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                if (c[row][col] != '*') {
                    c[row][col] = ' ';
                }
            }
        }
        //翻转
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < len; col++) {
                c[len - row - 1][len - col - 1] = c[row][col];
            }
        }

        //打印
        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                System.out.print(c[row][col]);
            }
            System.out.println();
        }
    }

}

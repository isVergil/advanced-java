package com.algorithm.huwei;

import java.util.Scanner;

/**
 * @ClassName HJ2022042001
 * @Description TODO
 * @Author bill
 * @Date 2022/7/5 18:12
 * @Version 1.0
 **/
public class HJ2022042001 {

    static int[] scores = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8, 8, 8, 8, 8};

    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        dfs(0, 0, score, 0);
        System.out.println(res);
    }

    static void dfs(int index, int cur, int score, int error) {
        if (cur == score) {
            res++;
            return;
        }
        if (error == 3 || cur > score || index == scores.length) {
            return;
        }
        //做对该题
        dfs(index + 1, cur + scores[index], score, error);
        //做错该题
        dfs(index + 1, cur, score, error + 1);

    }
}

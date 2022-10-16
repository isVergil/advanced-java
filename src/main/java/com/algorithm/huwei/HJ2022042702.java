package com.algorithm.huwei;


import java.util.Scanner;

/**
 * @ClassName HJ2022042702
 * @Description 项目规划
 * @Author bill
 * @Date 2022/7/5 18:56
 * @Version 1.0
 **/
public class HJ2022042702 {

    static int res = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //项目总数
        int n = in.nextInt();
        //3个 团队人力总和
        int[] sArr = new int[3];
        for (int i = 0; i < 3; i++) {
            sArr[i] = in.nextInt();
        }
        //n个 每个项目预估价值
        int[] vArr = new int[n];
        for (int i = 0; i < n; i++) {
            vArr[i] = in.nextInt();
        }
        //n个 每个项目所需人力
        int[][] pArr = new int[n][3];
        for (int i = 0; i < n; i++) {
            pArr[i][0] = in.nextInt();
            pArr[i][1] = in.nextInt();
            pArr[i][2] = in.nextInt();
        }
        dfs(0, 0, new int[3], vArr, pArr, sArr);
        System.out.println(res);
    }

    static void dfs(int index, int curV, int[] pUsed, int[] vArr, int[][] pArr, int[] sArr) {
        int n = vArr.length;
        res = Math.max(res, curV);
        if (index == n) {
            return;
        }
        //不选项目index
        dfs(index + 1, curV, pUsed, vArr, pArr, sArr);
        //选项目index
        for (int i = 0; i < 3; i++) {
            pUsed[i] += pArr[index][i];
        }
        //前端人力总和超过限制 || 后端人力总和超过限制 || 测试人力总和超过限制
        if (pUsed[0] > sArr[0] || pUsed[1] > sArr[1] || pUsed[2] > sArr[2]) {
            return;
        }
        dfs(index + 1, curV + vArr[index], pUsed, vArr, pArr, sArr);
        for (int i = 0; i < 3; i++) {
            pUsed[i] -= pArr[index][i];
        }
    }
}

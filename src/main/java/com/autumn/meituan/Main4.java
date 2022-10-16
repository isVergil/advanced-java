package com.autumn.meituan;

import java.util.Scanner;

/**
 * @ClassName Main4
 * @Description TODO
 * @Author bill
 * @Date 2022/9/3 11:13
 * @Version 1.0
 **/
public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //城市数量
        int m = sc.nextInt();  //总天数
        int k = sc.nextInt();  //初始所在城市
        // 第i天的任务所在地点
        taskDay = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            taskDay[i] = sc.nextInt();
        }
        // 完成第i天任务且地点不变的收益
        finsh0 = new long[m + 1];
        for (int i = 1; i <= m; i++) {
            finsh0[i] = sc.nextLong();
        }
        // 完成第i天的任务且地点改变的收益
        finsh1 = new long[m + 1];
        for (int i = 1; i <= m; i++) {
            finsh1[i] = sc.nextLong();
        }

        dfs(1, k, 0l, m);
        System.out.println(res);

    }

    static long res = 0;

    static int[] taskDay;

    static long[] finsh0;

    static long[] finsh1;

    //第 idx 天
    static void dfs(int idx, int curCity, long curMoney, int m) {
        if (idx > m) {
            res = Math.max(res, curMoney);
            return;
        }
        //选择完成当天任务
        if (curCity == taskDay[idx]) {
            dfs(idx + 1, curCity, curMoney + finsh0[idx], m);
        } else {
            dfs(idx + 1, taskDay[idx], curMoney + finsh1[idx], m);
        }
        //选择不完成当天任务
        dfs(idx + 1, curCity, curMoney, m);
    }

}

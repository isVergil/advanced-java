package com.autumn.jd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description TODO
 * @Author bill
 * @Date 2022/9/3 19:41
 * @Version 1.0
 **/
public class Main2 {

    static long[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new long[(int) 1e6];
        Arrays.fill(memo, -1);
        memo[1] = 0;
        memo[2] = 1;
        memo[3] = 2;
        long res = 0;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            long cur = dfs(nums[i]);
            System.out.print(cur + "\t");
            res += cur;
        }
        System.out.println();
        System.out.println("总最小 ："+res);
    }

    static long dfs(int cur) {
        if (memo[cur] != -1) {
            return memo[cur];
        }
        long cnt = Long.MAX_VALUE;
        if (cur % 3 == 0) {
            cnt = Math.min(dfs(cur / 3) + 3, cnt);
        }
        if (cur % 2 == 0) {
            cnt = Math.min(dfs(cur / 2) + 2, cnt);
        }
        cnt = Math.min(dfs(cur - 1) + 1, cnt);
        return memo[cur] = cnt;

    }

    // 10
    //         11 12 13 14 15 16 17 18 19 20
    //         7	6	7	7	7	7	8	7	8	8

    //655 135 5884 21 999 1467 22131 11 132 42
}

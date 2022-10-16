package com.internship.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * @ClassName MagicJump
 * @Description TODO
 * @Author bill
 * @Date 2022/4/19 22:54
 * @Version 1.0
 **/

/*
科科最近在修炼魔法，一日他来到魔法城堡，城堡里有一个长长的台阶,而台阶的最终点便是魔法奥秘。
这是一个魔力台阶，每个台阶都有一个魔力值，魔力值代表下一步科科最大可以跨越的台阶数。科科当前处在第1级台阶上，但是科科的体力有限，最多只能跨越K次。科科现在拜托你帮他计算下他能否拿到魔法奥秘。
如果能够拿到返回最少跨越的次数，拿不到则返回-1。解答要求
时间限制:C/C++ 1000ms,其他语言:2000ms内存限制:C/C++ 256MB,其他语言:512MB输入
台阶长度n (1<=n<=10^5)
台阶魔力值，[M1，M....Mn]由一个长度为n的数组表示，代表1~n级台阶的魔力值。(0<=Mi<=10^5)
最大的跨越次数K(1<=k<=10·5)输出
输出一个整数，拿到魔法奥秘最少需要跨越的次数，如果拿不到，返回-1

样例
 2 0 1 0 3  返回 -1
 2 1 5 6 2 3 (k = 3) 返回 2
 */
public class MagicJump {

    public static void main(String[] args) throws IOException {
        int j = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] powers = new int[n];
        String[] lines = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            powers[i] = Integer.parseInt(lines[i]);
        }
        int k = Integer.parseInt(br.readLine());
        int res = jump(powers);
        if (res > k) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }

    //暴力
    private static int dfs(int index, int[] powers) {
        if (index >= powers.length - 1) {
            return 0;
        }
        int ans = 100001;
        for (int i = 1; i <= powers[index]; i++) {
            int tmp = dfs(index + 1, powers);
            if (tmp != 100001) {
                ans = Math.min(ans, tmp + 1);
            }
        }
        return ans;
    }

    //贪心
    private static int jump(int[] powers) {
        int end = 0;
        int len = powers.length;
        int steps = 0;
        int maxPos = 0;
        for (int i = 0; i < len - 1; i++) {
            maxPos = Math.max(powers[i] + i, maxPos);
            if (end == i) {
                steps++;
                end = maxPos;
            }
        }
        return steps;
    }

}

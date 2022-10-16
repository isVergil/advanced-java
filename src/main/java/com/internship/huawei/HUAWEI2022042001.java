package com.internship.huawei;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @ClassName HUAWEI2022042001
 * @Description TODO
 * @Author bill
 * @Date 2022/4/20 21:12
 * @Version 1.0
 **/
/*
2 分 10 道
4 分 10 道
8 分 5  道

依次只能错3道
输入0 - 100 的分数 计算出有几种可能
 */
public class HUAWEI2022042001 {

    static int res = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] scores = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8, 8, 8, 8, 8};
        boolean[] isSelect = new boolean[scores.length];
        dfs(scores, isSelect, 0, 0, N);
        System.out.println(res);
    }

    static LinkedList<Integer> path = new LinkedList<>();

    static void dfs(int[] scores, boolean[] isSelect, int index, int curScore, int target) {
        if (index > scores.length || curScore > target) {
            return;
        }
        //错题超过3道 直接返回
        if (index - path.size() > 2) {
            return;
        }
        if (curScore == target) {
            res++;
            return;
        }
        for (int i = index; i < scores.length; i++) {
            if (isSelect[i]) {
                continue;
            }
            isSelect[i] = true;
            path.add(i);
            curScore += scores[i];
            dfs(scores, isSelect, i + 1, curScore, target);
            curScore -= scores[i];
            isSelect[i] = false;
            path.removeLast();
        }
    }
}

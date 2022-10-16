package com.internship.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName ShareSugars
 * @Description TODO
 * @Author bill
 * @Date 2022/4/19 21:49
 * @Version 1.0
 **/
/*
分糖果
老帅给韩悔梅和李雷分糖果,每袋糖果中的糖果数量不完全样，
一袋糖果只能分给一个人且所有糖果必须全部分完,
两个人分到的糖果数斌必须和同。
请返回两人分到的糖果数量,如果无法平均分配悉回-1.

解答要求
时问限制:C/CI+1000ms,其他语言:200ams内存限制:C/C++256MB,其他语言:512MB输入
第一行输入为指果的袋数,取值故阀为[1,10O[;
第二行输入为一个整璧数组,播述每袋糖果中的糖果数量,每个元素的取值范国为[1.100]输出
第一行为每人平均分配到的糖果取。如果不能平均分配题为-1.
第二行、第三行为李雷和韩梅梅分配到的每袋糖嗳中的糖果数,顺序不限。样例1
输入:2100 100输出:100100100样例2输入:5
74533输出:117433
 */
public class ShareSugars {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sugars = new int[N];
        String[] lines = br.readLine().split(" ");
        int sum = 0;   //统计和
        for (int i = 0; i < N; i++) {
            sugars[i] = Integer.parseInt(lines[i]);
            sum += sugars[i];
        }
        if (sum % 2 != 0 || N == 1) {
            System.out.println(-1);
            return;
        }
        List<Integer> path = new ArrayList<>();
        dfs(0, 0, path, sum / 2, sugars);
        if (res != null) {
            System.out.println(sum / 2);
            res.forEach(item ->
                    System.out.print(sugars[item] + " ")
            );
            System.out.println();
            for (int i = 0; i < N; i++) {
                if (!res.contains(i)) {
                    System.out.print(sugars[i] + " ");
                }
            }
        } else {
            System.out.println(-1);
        }

    }

    static List<Integer> res;

    private static void dfs(int index, int cursum, List<Integer> path, int target, int[] sugars) {
        if (cursum >= target) {
            if (cursum == target) {
                res = new ArrayList<>(path);
            }
            return;
        }
        if (index >= sugars.length) {
            return;
        }
        boolean ans = false;
        for (int i = index; i < sugars.length; i++) {
            path.add(i);
            cursum += sugars[i];
            dfs(i + 1, cursum, path, target, sugars);
            if (res != null) {
                return;
            }
            cursum -= sugars[i];
            path.remove(path.size() - 1);
        }
    }
}

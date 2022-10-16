package com.internship.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description TODO
 * @Author bill
 * @Date 2022/4/21 19:37
 * @Version 1.0
 **/
public class Main2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int x = scanner.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            sum += nums[i];
        }
        int[] tmpNum = new int[p];
        for (int i = 0; i < p; i++) {
            tmpNum[i] = i + 1;
        }
        Arrays.sort(nums);
        int[] res = new int[n];
        int tmpSum = 0;
        for (int i = 0; i < n; i++) {
            if (i > 1 && nums[i] == nums[i - 1]) {
                res[i] = res[i - 1];
                continue;
            }
            if (i > 1) {
                res[i] = res[i - 1];
            }
            for (int j = 0; j < tmpNum.length; j++) {
                if (nums[i] != tmpNum[j]) {
                    tmpSum = sum - nums[i] + tmpNum[j];
                    if (tmpSum % x == 0) {
                        res[i] += 1;
                    }
                }
            }
        }
        int ans = 0;
        for (int re : res) {
            ans += re;
        }
        System.out.println(ans);

    }

    static int res = 0;


    static void backtrace(int[] nums, int sum, int n, int index, int[] tmpNum, int x) {
        if (index >= n) {
            return;
        }
        int tmpSum = 0;
        for (int j = 0; j < tmpNum.length; j++) {
            if (nums[index] != tmpNum[j]) {
                tmpSum = sum - nums[index] + tmpNum[j];
                if (tmpSum % x == 0) {
                    res++;
                }
            }
        }
        backtrace(nums, sum, n, index + 1, tmpNum, x);
    }
}

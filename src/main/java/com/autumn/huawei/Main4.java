package com.autumn.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Main4
 * @Description TODO
 * @Author bill
 * @Date 2022/9/21 19:12
 * @Version 1.0
 **/
import java.util.*;

public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            total += nums[i];
        }
        int limit = sc.nextInt();
        if (limit >= total) {
            System.out.println(-1);
            return;
        }
        Arrays.sort(nums);
        int l = nums[0], r = nums[n - 1];
        while (l < r) {
            int curLimit = (l + r + 1) >> 1;
            if (check(curLimit, nums, limit)) {
                l = curLimit;
            } else {
                r = curLimit - 1;
            }
        }
        System.out.println(l);
    }

    static boolean check(int limit, int[] nums, long total) {
        long curTotal = 0;
        for (int num : nums) {
            if (limit >= num) {
                curTotal += num;
            } else {
                curTotal += limit;
            }
        }
        return curTotal <= total;
    }
}

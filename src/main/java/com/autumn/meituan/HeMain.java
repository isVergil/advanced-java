package com.autumn.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName HeMain
 * @Description TODO
 * @Author bill
 * @Date 2022/9/17 11:19
 * @Version 1.0
 **/
public class HeMain {

    static long res = 1000;

    /*
     5
     7 3 11 5 2
     */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        Arrays.sort(nums);
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(l, mid, r, sum, nums)) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println(res);
    }

    static boolean check(int l, int mid, int r, long sum, int[] nums) {
        //左边和 Sn = n * (a1 + an) / 2
        int leftSum = 0;
        if (mid != l) {
            leftSum = (mid - l + 1) * (nums[mid] + nums[mid] - mid - l) / 2;
        }
        int rightSum = 0;
        if (mid != r) {
            rightSum = (r - mid + 1) * (nums[mid] + nums[mid] + r - mid) / 2;
        }
        long cur = sum - leftSum - rightSum + nums[mid];
        res = cur < res ? cur : res;
        if (cur < res) {
            return true;
        }
        return false;
    }
}

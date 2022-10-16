package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName LuoXuan
 * @Description TODO
 * @Author bill
 * @Date 2022/9/16 15:53
 * @Version 1.0
 **/


public class LuoXuan {

    /*
     1        ***        n
     3n-3     ***       n+1
     ...
     ...
     2n  2n-2
     2n-1
     */

    public static void main(String[] args) {
        // int n = 10;
        // List<int[]> list = new ArrayList<>();
        // for (int i = 0; i < n; i++) {
        //     list.add(new int[n - i]);
        // }
        // int cur = 1;
        // int leftStart = 0;
        // int RightStart = 0;
        // for (int i = 0; i < list.size(); i++) {
        //     //从左往右
        //     int[] left2R = list.get(i);
        //     for (int j = leftStart; j < n - 2 * leftStart; j++) {
        //         left2R[j] = cur++;
        //     }
        //     //从右上角到左下角
        //     for (int j = i + 1; j < n - 2 * leftStart; j++) {
        //         list.get(j)[list.get(j).length - i] = cur++;
        //     }
        //     //从下往上

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long x = sc.nextLong();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        long l = -1;
        long r = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (l < nums[i]) {
                l = nums[i];
            }
            if (r > nums[i]) {
                r = nums[i];
            }
            if (Math.abs(x + r - l) > x) {
                cnt++;
                if (l == nums[i]) {
                    r = l;
                } else {
                    l = r;
                }
            }
        }
        System.out.println(cnt);


    }


}

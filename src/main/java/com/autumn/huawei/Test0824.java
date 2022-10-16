package com.autumn.huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName Test0825
 * @Description TODO
 * @Author bill
 * @Date 2022/8/25 23:25
 * @Version 1.0
 **/
public class Test0824 {

    //1 分配捐款

    /***
     5
     2 9 3 1 6
     4
     out  3 1

     3
     10 3 1
     8
     out  2 1

     4
     1 3 6 10
     17
     3 1
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] ms = new int[m];
        for (int i = 0; i < m; i++) {
            ms[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        Arrays.sort(ms);
        int finalCnt = 1;
        int finalRest = n;
        int l = 0, r = 1;
        while (r < m) {
            if (l == r - 1 && n < ms[r] - ms[l]) {
                l++;
                r++;
            } else {
                int rest = n;
                int cnt = 1;
                while (r < m && rest > 0) {
                    if (rest >= (ms[r] - ms[r - 1]) * (r - l)) {
                        rest -= (ms[r] - ms[r - 1]) * (r - l);
                        cnt++;
                        r++;
                        continue;
                    }
                    break;
                }
                if (cnt > finalCnt) {
                    finalCnt = cnt;
                    finalRest = rest;
                } else if (cnt == finalCnt) {
                    finalRest = Math.min(finalRest, rest);
                }
                l++;
                r = l + 1;
            }
        }
        System.out.println("finalCnt:" + finalCnt);
        System.out.println("finalRest:" + finalRest);

    }
}

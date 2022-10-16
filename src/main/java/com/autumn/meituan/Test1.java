package com.autumn.meituan;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName Test1
 * @Description TODO
 * @Author bill
 * @Date 2022/8/12 22:00
 * @Version 1.0
 **/
public class Test1 {

    //T1
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int T = sc.nextInt();
    //     while (T-- > 0) {
    //         int x = sc.nextInt();
    //         int y = sc.nextInt();
    //         int max = Math.max(x, y);
    //         int min = Math.min(x, y);
    //         if (max - min >= min) {
    //             System.out.println(min);
    //         } else {
    //             int cur = min * 2 - (max - min) * 2;
    //             System.out.println(cur / 3 + max - min);
    //         }
    //     }
    // }

    //T2
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[] nums = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         nums[i] = sc.nextInt();
    //     }
    //     //从左至右 当前点左边的异常数量
    //     int[] left2Right = new int[n];
    //     for (int i = 1; i < n; i++) {
    //         if (nums[i - 1] >= 0) {
    //             left2Right[i] = (left2Right[i - 1] + 1);
    //         } else {
    //             left2Right[i] = left2Right[i - 1];
    //         }
    //     }
    //     //从右至左 当前点右边的异常数量
    //     int[] right2Left = new int[n];
    //     for (int i = n - 2; i >= 0; i--) {
    //         if (nums[i + 1] <= 0) {
    //             right2Left[i] = (right2Left[i + 1] + 1);
    //         } else {
    //             right2Left[i] = right2Left[i + 1];
    //         }
    //     }
    //     //res 最大是 n - 1
    //     int res = n - 1;
    //     //计算最小的那个
    //     for (int i = 0; i < n; i++) {
    //         res = Math.min(res, left2Right[i] + right2Left[i]);
    //     }
    //     System.out.println(res);
    // }

    //T3
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     Map<Integer, Integer> mapPost = new HashMap<>();
    //     Map<Integer, Integer> mapNega = new HashMap<>();
    //     int tmp = n;
    //     while (tmp-- > 0) {
    //         int cur = sc.nextInt();
    //         mapPost.put(cur, mapPost.getOrDefault(cur, 0) + 1);
    //     }
    //     tmp = n;
    //     while (tmp-- > 0) {
    //         int cur = sc.nextInt();
    //         mapNega.put(cur, mapPost.getOrDefault(cur, 0) + 1);
    //     }
    //     int res = (int) 1e6;
    //     for (int i : mapPost.keySet()) {
    //         if (mapPost.get(i) * 2 >= n) {
    //             System.out.println(0);
    //             return;
    //         }
    //         if ((mapNega.getOrDefault(i, 0) + mapPost.get(i)) * 2 >= n) {
    //             res = Math.min(res, (n + 1) / 2 - mapPost.get(i));
    //         }
    //     }
    //     if (res == 1000000) {
    //         System.out.println(-1);
    //     } else {
    //         System.out.println(res);
    //     }
    //
    // }

    //T4
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int k = sc.nextInt();
    //     int[] tests = new int[n];
    //     int[] types = new int[k + 1];
    //     for (int i = 0; i < n; i++) {
    //         tests[i] = sc.nextInt();
    //         types[tests[i]]++;
    //     }
    //     for (int i = 1; i <= k; i++) {
    //         types[i] = (types[i] + 1) / 2;
    //     }
    //     String s1 = "";
    //     String s2 = "";
    //     for (int i = 0; i < n; i++) {
    //         if (types[tests[i]] > 0) {
    //             s1 += (i + 1 + " ");
    //             types[tests[i]]--;
    //         } else {
    //             s2 += (i + 1 + " ");
    //         }
    //     }
    //     System.out.println(s1);
    //     System.out.println(s2);
    //
    // }

    //T5
    public static void main(String[] args) {
        System.out.println(dfs("MeiTuan", 3));
        //MeiTuannauTieMwowwowMeiTuannauTieMwowwowMeiTuannauTieMwowwowMeiTuannauTieMwow
        //MeiTuannauTieMwowwow 的循环
        String s = "MeiTuannauTieMwowwow";
        long n = s.length();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            long cur = sc.nextLong();
            long t = cur % n;
            if (t == 0) {
                s.charAt((int) n - 1);
            }
            System.out.println(s.charAt((int) t - 1));
        }


    }

    static String dfs(String s, int cur) {
        if (cur == 0) {
            return s;
        }
        return dfs(s + new StringBuilder(s).reverse().toString() + "wow", cur - 1);
    }

}

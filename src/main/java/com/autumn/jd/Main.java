package com.autumn.jd;

import java.util.*;

/**
 * @ClassName Main
 * @Description TODO
 * @Author bill
 * @Date 2022/8/27 19:34
 * @Version 1.0
 **/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }
        if (n <= 2) {
            System.out.println(0);
            return;
        }
        //奇数
        // Map<Integer, Integer> map0 = new HashMap<>();
        // for (int i = 0; i < n; i += 2) {
        //     map0.put(nums[i], map0.getOrDefault(nums[i], 0) + 1);
        // }
        // //偶数
        // Map<Integer, Integer> map1 = new HashMap<>();
        // for (int i = 1; i < n; i += 2) {
        //     map1.put(nums[i], map1.getOrDefault(nums[i], 0) + 1);
        // }
        // int res0 = n - 1;
        // int maxNum0 = 0;
        // int maxCnt0 = 0;
        // for (int i : map0.keySet()) {
        //     if (map0.get(i) > maxCnt0) {
        //         maxNum0 = i;
        //         maxCnt0 = map0.get(i);
        //     }
        // }
        // int maxNum1 = 0;
        // int maxCnt1 = 0;
        // for (int i : map1.keySet()) {
        //     if (map1.get(i) > maxCnt1) {
        //         maxNum1 = i;
        //         maxCnt1 = map1.get(i);
        //     }
        // }
        // //最大的数相等
        // if (maxNum0 == maxNum1) {
        //
        // } else {
        //     System.out.println(n - maxCnt1 - maxCnt0);
        // }

        //奇数
        Map<Long, Long> map0 = new HashMap<>();
        for (int i = 0; i < n; i += 2) {
            map0.put(nums[i], map0.getOrDefault(nums[i], 0L) + 1);
        }
        //偶数
        Map<Long, Long> map1 = new HashMap<>();
        for (int i = 1; i < n; i += 2) {
            map1.put(nums[i], map1.getOrDefault(nums[i], 0L) + 1);
        }
        Comparator<Map.Entry<Long, Long>> comparator = new Comparator<Map.Entry<Long, Long>>() {
            @Override
            public int compare(Map.Entry<Long, Long> o1, Map.Entry<Long, Long> o2) {
                return (int) (o2.getValue() - o1.getValue());
            }
        };
        List<Map.Entry<Long, Long>> list0 = new ArrayList<Map.Entry<Long, Long>>(map0.entrySet());
        Collections.sort(list0, comparator);
        List<Map.Entry<Long, Long>> list1 = new ArrayList<Map.Entry<Long, Long>>(map1.entrySet());
        Collections.sort(list1, comparator);
        //最大的元素相等
        if (list0.get(0).getKey() == list0.get(1).getKey()) {
            //最大的元素相等  数量也相等
            if (list0.get(0).getValue() == list0.get(1).getValue()) {
                if (list0.get(0).getValue() * 2 == n) {
                    System.out.println(0);
                    return;
                }
                //取第二 大的那个
                long max2 = 0l;
                if (list0.size() > 1) {
                    max2 = Math.max(max2, list0.get(1).getValue());
                }
                if (list1.size() > 1) {
                    max2 = Math.max(max2, list1.get(1).getValue());
                }
                System.out.println(n - list0.get(0).getValue() - max2);
            }
            System.out.println(n - list0.get(0).getKey());
        } else {   //最大的元素不等
            System.out.println(n - list0.get(0).getValue() - list1.get(0).getValue());
        }


    }
}

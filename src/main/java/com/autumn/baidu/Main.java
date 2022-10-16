package com.autumn.baidu;

import java.util.*;

/**
 * @ClassName Main
 * @Description TODO
 * @Author bill
 * @Date 2022/10/11 19:48
 * @Version 1.0
 **/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            cal(n, k, nums);
        }
    }


    static void cal(int n, int k, int[] nums) {
        Arrays.sort(nums);
        int l = nums[0];
        int r = nums[n - 1];
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer num : map.keySet()) {
            list.add(num);
        }
        int len = list.size();
        for (int i = 0; i < len; i++) {
            int curK = 0;
            int curL = list.get(i);
            int idx = i;
            while (idx < len) {
                curK += map.get(list.get(idx));
                if (curK > k) {
                    break;
                }
                if (curK == k) {
                    System.out.println(curL + " " + list.get(idx));
                    return;
                }
                idx++;
            }
            i++;
        }
        System.out.println(-1);

    }
}

package com.autumn.meituan;

import java.util.*;

/**
 * @ClassName Main1
 * @Description TODO
 * @Author bill
 * @Date 2022/9/3 10:02
 * @Version 1.0
 **/
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] copy = new int[list.size()];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = list.get(i);
        }
        Arrays.sort(copy);
        if (copy[0] > 0) {
            for (int i = 0; i < n; i++) {
                System.out.println(0);
            }
        } else {
            int curMin = 0;
            for (int i = 0; i < copy.length; i++) {
                if (copy[i] == i) {
                    map.put(copy[i], i);
                    curMin++;
                } else {
                    map.put(copy[i],curMin);
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.println(map.get(nums[i]));
            }
        }



    }
}

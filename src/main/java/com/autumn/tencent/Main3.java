package com.autumn.tencent;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName Main3
 * @Description TODO
 * @Author bill
 * @Date 2022/10/16 21:05
 * @Version 1.0
 **/
public class Main3 {

    //10010110
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int sum1 = 0, sum2 = 0;
        int[] nums1 = nums.clone();
        Arrays.sort(nums1);
        for (int i = n - 1; i >= 0; i--) {
            if (sum1 <= sum2) {
                list1.add(nums1[i]);
                sum1 += nums1[i];
            } else {
                list2.add(nums1[i]);
                sum2 += nums1[i];
            }
        }
        System.out.println(sum1 + " " + "-" + sum2);
        for (int i = 0; i < n; i++) {
            if (list1.contains(nums[i])) {
                System.out.print("Y");
                list1.remove((Integer) nums[i]);
            } else {
                System.out.print("X");
                list2.remove((Integer) nums[i]);
            }
        }
    }

}

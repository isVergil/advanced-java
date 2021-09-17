package com.algorithm.leetcode;

import java.util.*;

/**
 * @ClassName LC15
 * @Description TODO
 * @Author bill
 * @Date 2021/9/17 15:23
 * @Version 1.0
 **/
public class LC15 {
    //O(n^2)
    //排序 + 双指针
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {    //正好和为 0 满足条件
                    set.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else if (sum < 0) {   //小于 0 增加和 l++
                    l++;
                } else {                //大于 0 减小和 r--
                    r--;
                }
            }
        }
        res.addAll(set);
        return res;
    }

    public void quickSort(int[] nums, int left, int right) {
        int l = left, r = right;
        while (l < r) {
            while (l < r && nums[left] < nums[r]) {
                r--;
            }
            while (l < r && nums[left] > nums[l]) {
                l++;
            }
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
        quickSort(nums, left, l - 1);
        quickSort(nums, l + 1, right);
    }
}

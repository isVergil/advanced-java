package com.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LC1
 * @Description TODO
 * @Author bill
 * @Date 2021/9/17 15:16
 * @Version 1.0
 **/
/*
两数之和
 */
public class LC1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}

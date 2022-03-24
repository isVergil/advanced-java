package com.algorithm.LeetCode热题HOT100;

import java.util.*;

/**
 * @ClassName LC15
 * @Description TODO
 * @Author bill
 * @Date 2022/3/17 14:30
 * @Version 1.0
 **/
public class LC15 {


    //法1
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if (nums == null || nums.length <= 2) {
            return res;
        }
        Arrays.sort(nums);
        //以nums[i]开始在后面找2个数凑成满足条件的三个数
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            //去除重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int tmptarget = nums[left] + nums[right];
                if (tmptarget == target) {
                    res.add(new ArrayList(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    //去除重复
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (tmptarget < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    //法2 暴力 set去重
    public List<List<Integer>> threeSum1(int[] nums) {
        //先排序
        int n = nums.length;
        //Arrays.sort(nums);
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {    //和为 0 符合情况 直接加入 set
                    set.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else if (sum < 0) {   //和小于 0 增加其中的一个元素 即 l++
                    l++;
                } else {               //和大于 0 减少其中的一个元素 即 r--
                    r--;
                }
            }
        }
        // if(set.size() > 0){
        //     for(List<Integer> item : set){
        //         ans.add(item);
        //     }
        // }
        ans.addAll(set);
        return ans;
    }

}

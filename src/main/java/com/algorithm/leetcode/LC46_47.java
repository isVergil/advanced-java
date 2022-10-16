package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LC46_47
 * @Description TODO
 * @Author bill
 * @Date 2022/4/30 22:18
 * @Version 1.0
 **/
//lc46  全排列
//lc47  全排列2
//lc78  子集
public class LC46_47 {

    List<List<Integer>> res = new ArrayList();
    List<Integer> path = new ArrayList();


    //lc46 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
    public List<List<Integer>> permute(int[] nums) {
        backtrack46(nums);
        return res;
    }

    public void backtrack46(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backtrack46(nums);
            path.remove(path.size() - 1);
        }
    }

    //lc47 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        backtrace(nums, new boolean[nums.length]);
        return res;
    }

    void backtrace(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            //剪枝条件是：上一个元素已经被使用过撤销掉了，当前元素与上一个元素相同就应该被剪枝
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtrace(nums, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    //lc78  给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList();
        path = new ArrayList();
        backtrack(nums, 0);
        return res;
    }

    void backtrack(int[] nums, int index) {
        res.add(new ArrayList(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}

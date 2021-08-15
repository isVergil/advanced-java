package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName test3
 * @Description TODO
 * @Author bill
 * @Date 2021/8/15 15:28
 * @Version 1.0
 **/
public class test3 {
    public static void main(String[] args) {
        new test3().permute(new int[]{1, 2, 3});
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return result;
    }

    void backtracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}

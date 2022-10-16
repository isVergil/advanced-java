package com.test;

import java.util.Arrays;

/**
 * @ClassName FindDifference
 * @Description TODO
 * @Author bill
 * @Date 2022/9/20 9:58
 * @Version 1.0
 **/
public class FindDifference {

    public static void main(String[] args) {

    }

    static int partSort(int[] nums) {
        Arrays.sort(nums);
        int r = nums.length - 1;
        int l = 0;
        while (l < r) {
            //从后往前
            int rIdx = r;
            while (rIdx > 0 && nums[rIdx] == nums[rIdx - 1]) {
                rIdx--;
            }
        }
        return 0;
    }
}

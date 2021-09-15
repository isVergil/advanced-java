package com.internship.bytedance;

/**
 * @ClassName LC_41
 * @Description TODO
 * @Author bill
 * @Date 2021/9/10 16:57
 * @Version 1.0
 **/
/*
缺失的第一个正数

给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */
public class LC_41 {

    //法1 哈希函数的思想  所求正整数的范围是 [1,n+1]
    //1、将负数变成 n+1
    //2、将 <= n 的元素对应位置变成负数
    //3、返回第一个大于 0 的元素下标 + 1
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = nums[i];
            if (nums[i] <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    //法2 置换
    //如果数组中包含 x∈[1,N]，那么恢复后，数组的第 x−1 个元素为 x。
    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            //nums[nums[i] - 1] != nums[i] 用于跳出循环
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}

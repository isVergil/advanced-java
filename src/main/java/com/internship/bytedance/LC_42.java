package com.internship.bytedance;

/**
 * @ClassName LC_42
 * @Description TODO
 * @Author bill
 * @Date 2021/12/10 16:51
 * @Version 1.0
 **/
/*
接雨水
 */
public class LC_42 {

    //法1 暴力法（按列求积水）
    //木桶原理：对于要求的列可以存放的水只取决于他两边最矮的列
    //所求列能装的水 = min(所求列左边最高的列，所求列右边最高的列) - 当前列的高度
    //这里 maxLeft和maxRight 是包含 height[j] 本身的，因此后面累计不需要判断 是否大于 height[j] 而直接累加
    public int trap1(int[] height) {
        int res = 0;
        int len = height.length;
        for (int i = 1; i < len - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j < len; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            res += (Math.min(maxLeft, maxRight) - height[i]);
        }
        return res;
    }

    //法2 动态规划（思想同上）
    //空间换时间 用数组来存储 maxLeft 和 maxRight 而不需要重复计算
    //注意这里 maxLeft[i] 和 maxRight[i] 都不带 i 的结果 表示 i 两边的最大值
    public int trap2(int[] height) {
        int res = 0;
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        for (int i = 1; i < len - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        for (int i = 1; i < len - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                res += (min - height[i]);
            }
        }
        return res;
    }

    //法3 双指针 同上 只不过节约了空间
    //如果left_max<right_max成立，那么它就知道自己能存多少水了。无论右边将来会不会出现更大的right_max，都不影响这个结果
    public int trap3(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            left_max = Math.max(left_max, height[left]);
            right_max = Math.max(right_max, height[right]);
            if (left_max <= right_max) {
                ans += (left_max - height[left]);
                ++left;
            } else {
                ans += (right_max - height[right]);
                --right;
            }
        }
        return ans;
    }
}

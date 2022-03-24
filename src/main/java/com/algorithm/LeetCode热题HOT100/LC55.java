package com.algorithm.LeetCode热题HOT100;

/**
 * @ClassName LC55
 * @Description 55. 跳跃游戏
 * @Author bill
 * @Date 2022/3/23 16:25
 * @Version 1.0
 **/
public class LC55 {
    //如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点
    //可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新
    //如果可以一直跳到最后，就成功了
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}

package com.algorithm.LeetCode热题HOT100;

/**
 * @ClassName LC11
 * @Description 盛最多水的容器
 * @Author bill
 * @Date 2022/3/17 14:03
 * @Version 1.0
 **/
public class LC11 {

    //双指针
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            if (height[i] > height[j]) {
                res = Math.max(res, (j - i) * height[j]);
                j--;
            } else {
                res = Math.max(res, (j - i) * height[i]);
                i++;
            }
        }
        return res;
    }

}

package com.algorithm.LeetCode热题HOT100;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LC1
 * @Description TODO
 * @Author bill
 * @Date 2021/10/28 20:25
 * @Version 1.0
 **/
/*
两数之和
并返回它们的数组下标。

语句1：int[] a; //只是声明了一个数组变量，并未初始化，无法使用。
语句2：int[] a = null;//声明了一个数组变量，赋值为 null; 空指针不能使用数组的方法
语句3：int[] a = new int[0];//声明并创建一个数组对象，长度为0，没有内容
所以对于数组，不但要判断它是否为空指针，也需要判断它是否有内容，同时要先判断空指针再判断长度是否为0，顺序不能颠倒，因为空指针没有length属性
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

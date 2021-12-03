package com.algorithm.剑指offer;

import java.util.HashSet;
import java.util.Set;

/*
数组中重复的数字

在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
返回重复的数字 没找到返回-1

https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class JZ03 {
    //自写
    public int findRepeatNumber4(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int[] numbers = new int[nums.length];
        for (int num : nums) {
            if (numbers[num] <= 1) {
                numbers[num]++;
            } else {
                return num;
            }
        }
        return -1;
    }

    //方法1 HashSet 不重复的性质
    //O(n)  O(n)
    public int findRepeatNumber1(int[] nums) {
        if (nums == null) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        int result = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                result = num;
                break;
            }
        }
        return result;
    }

    //方法2 原地交换
    //利用题目条件  长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
    //遍历将元素放到索引为元素值的位置
    //O(n)  O(1)
    public int findRepeatNumber2(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            //元素值跟索引不对应则
            while (nums[i] != i) {
                //索引上已有值 则为重复
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                //否则交换
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        //循环退出都还没找到 返回 -1
        return -1;
    }

    //方法2 简化代码  注意交换顺序
    public int findRepeatNumber3(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            //nums[nums[i]] 要作为 temp ，先后赋值 nums[nums[i]]、nums[i] ，顺序不能变
            //因为先赋值 nums[i] ，nums[nums[i]] 的值就变了，因此顺序不能变
            temp = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = temp;
        }
        return -1;
    }
}

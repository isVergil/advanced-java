package com.algorithm.剑指offer;

import java.util.Arrays;

/**
 * @ClassName JZ61
 * @Description TODO
 * @Author bill
 * @Date 2021/9/19 17:27
 * @Version 1.0
 **/
/*
扑克牌中的顺子

从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，
A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 */
public class JZ61 {

    //最大牌 - 最小牌 < 5
    public boolean isStraight(int[] nums) {
        //Arrays.sort(nums);
        quickSort(nums, 0, nums.length - 1);
        int jokerCount = 0;
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                jokerCount++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return nums[4] - nums[jokerCount] < 5;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left, r = right;
        while (l < r) {
            while (l < r && nums[r] >= nums[left]) {
                r--;
            }
            while (l < r && nums[l] <= nums[left]) {
                l++;
            }
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
        int temp = nums[l];
        nums[l] = nums[left];
        nums[left] = temp;
        quickSort(nums, left, l - 1);
        quickSort(nums, l + 1, right);
    }

    //自写
    //计算 0 的个数 count0
    //计算相邻两个数的差值 - 1 的和 count1
    // count0 >= count1 即表示 0 可填充掉多余的数
    public boolean IsContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 5) {
            return false;
        }
        Arrays.sort(numbers);
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                count0++;
            } else {
                if (numbers[i + 1] == numbers[i]) {
                    return false;
                }
                count1 += (numbers[i + 1] - numbers[i] - 1);
            }
        }
        if (count0 >= count1) {
            return true;
        }
        return false;
    }
}

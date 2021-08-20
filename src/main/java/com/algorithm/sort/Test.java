package com.algorithm.sort;

import java.util.Arrays;

/**
 * @ClassName Test
 * @Description TODO
 * @Author bill
 * @Date 2021/7/11 10:17
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        int[] test = new int[]{123, 435, 678, 2343, 6547, 65, 867, 7, 3, 525, 3, 8, 585, 67};
        //bubbleSort(test);
        //selectSort(test);
        //System.out.println(Arrays.toString(test));

        quickSort(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
    }

    //从前往后 交换最大的放到后面
    public static void bubbleSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //每次选择最小放到前面 作为排好序的序列
    public static void selectSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] nums, int left, int right) {
//        if (nums == null || nums.length < 2) {
//            return;
//        }
        if (left >= right) {
            return;
        }
        int l = left, r = right;
        while (l < r) {
            //从右往左找 直到找到比 基准 nums[left] 小的
            while (l < r && nums[r] >= nums[left]) {
                r--;
            }
            //从左往右找 直到找到比 基准 nums[left] 大的
            while (l < r && nums[l] <= nums[left]) {
                l++;
            }
            //交换这两个数 nums[r] 和 nums[l]
            swap(nums, l, r);
        }
        //交换基准 nums[left] 让左边的数小于 nums[left] 右边的数大于 nums[left]
        swap(nums, l, left);
        quickSort(nums, left, l - 1);
        quickSort(nums, l + 1, right);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


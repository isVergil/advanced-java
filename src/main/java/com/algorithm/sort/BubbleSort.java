package com.algorithm.sort;

import java.util.Arrays;

/**
 * @ClassName BubbleSort
 * @Description TODO
 * @Author bill
 * @Date 2021/7/7 20:41
 * @Version 1.0
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] test = new int[]{123, 435, 678, 2343, 6547, 65, 867, 7, 3, 525, 3, 8, 585, 67};
        System.out.println(Arrays.toString(test));

        //myBubbleSort(test);
        myBubbleSort(test);

        System.out.println(Arrays.toString(test));

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void myBubbleSort(int[] nums) {
        if (nums.length < 1)
            return;
        for (int i = 0; i < nums.length; i++) {
            //flag 作是否排好序的标记 作为优化  没必要
            boolean flag = true;
            for (int j = 1; j < nums.length - i; j++) {
                //修改 < > 号进行降升序
                if (nums[j] < nums[j - 1]) {
                    flag = false;
                    swap(nums, j, j - 1);
                }
            }
            if (flag) {
                break;
            }
        }
    }

    private static void bubbleSortMethod1(int[] numbers) {
        if (numbers.length < 1)
            return;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }
}

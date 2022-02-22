package com.algorithm.sort;

import java.util.Arrays;

/**
 * @ClassName SelectSort
 * @Description TODO
 * @Author bill
 * @Date 2021/7/7 21:08
 * @Version 1.0
 * 每次选择最小放到未排序的最前面 交换
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] test = new int[]{123, 435, 678, 2343, 6547, 65, 867, 7, 3, 525, 3, 8, 585, 67};
        System.out.println(Arrays.toString(test));

        mySelectSort(test);

        System.out.println(Arrays.toString(test));
    }

    private static void mySelectSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    //选择
    //稳定 平均 O(n^2)  最坏 O(n^2)  最好 O(n^2)
    public void selectSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                //升序
                if (arr[j] < arr[i]) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }

}

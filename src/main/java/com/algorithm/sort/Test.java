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
        selectSort(test);
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
}


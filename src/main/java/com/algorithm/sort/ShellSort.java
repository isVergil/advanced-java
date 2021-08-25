package com.algorithm.sort;

import java.util.Arrays;

/**
 * @ClassName ShellSort
 * @Description TODO
 * @Author bill
 * @Date 2021/7/11 15:05
 * @Version 1.0
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] test = {123, 435, 678, 2343, 6547, 65, 65, 867, 7, 3, 3, 525, 6532, 8, 585, 67};
        shellSort(test);
        System.out.println(Arrays.toString(test));
    }

    private static void shellSort(int[] arr) {
        int step = arr.length / 2;
        //创建一个循环来控制希尔排序中使用步长的变化
        while (step >= 1) {
            //创建一个循环来控制参与内部差值排序的起点下标
            for (int start = 0; start < step; start++) {
                insertSort(arr, step, start);
            }
            step /= 2;
        }
    }

    /**
     * @param arr   待排序
     * @param step  步长
     * @param start 起始下标
     * @author bill
     * @description 插入排序
     * @updateTime 2021/7/11  15:21
     */
    private static void insertSort(int[] arr, int step, int start) {
        //从 起点加步长 的那个元素开始插入排序
        for (int i = start + step; i < arr.length; i += step) {
            //把 arr[i] 添加进排好序的队列
            for (int j = i; j - step >= 0; j -= step) {
                if (arr[j] < arr[j - step]) {
                    int temp = arr[j];
                    arr[j] = arr[j - step];
                    arr[j - step] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
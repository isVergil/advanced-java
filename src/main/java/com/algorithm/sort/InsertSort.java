package com.algorithm.sort;

import java.util.Arrays;

/**
 * @ClassName InsertSort
 * @Description 插入排序： 直接插入和希尔排序
 * @Author bill
 * @Date 2021/7/11 14:48
 * @Version 1.0
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] test = {123, 435, 678, 2343, 6547, 65, 65, 867, 7, 3, 3, 525, 6532, 8, 585, 67};
        insertSort(test);
        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(insertSort1(test)));
    }

    //1、直接插入排序
    //arr[0] 当成是排好序的序列，继续往里插入进行排序（通过交换）
    //因为有 break 所以用时较少
    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //把 arr[i] 添加进排好序的队列
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static int[] insertSort1(int[] arr) {
        if(arr == null || arr.length < 2)
            return arr;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int k = i - 1;
            while(k >= 0 && arr[k] > temp)
                k--;
            //腾出位置插进去,要插的位置是 k + 1;
            for(int j = i ; j > k + 1; j--)
                arr[j] = arr[j-1];
            //插进去
            arr[k+1] = temp;
        }
        return arr;
    }

    //2、希尔排序
    //https://blog.csdn.net/qq_34686440/article/details/105155606
    //初始取步长 arr.length / 2 分割 arr 为小数组进行比较
    //然后取步长减半 继续分割直到 步长==1 即比较相邻元素，整个数组为一组有序序列
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
     * @description 类似直接插入排序
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

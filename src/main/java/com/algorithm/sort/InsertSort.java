package com.algorithm.sort;

import java.util.Arrays;

/**
 * @ClassName InsertSort
 * @Description TODO
 * @Author bill
 * @Date 2021/7/11 14:48
 * @Version 1.0
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] test = {123, 435, 678, 2343, 6547, 65, 65, 867, 7, 3, 3, 525, 6532, 8, 585, 67};
        insertSort(test);
        System.out.println(Arrays.toString(test));
    }

    //因为有 break 所以用时较少
    private static void insertSort(int[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            //把 arr[i] 添加进排好序的队列
//            for (int j = i; j > 0; j--) {
//                if (arr[j] < arr[j - 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j - 1];
//                    arr[j - 1] = temp;
//                } else {
//                    break;
//                }
//            }
//        }

        for (int i = 1; i < arr.length; i++) {
            //把 arr[i] 添加进排好序的队列
            for (int j = i; j > 0 && (arr[j] < arr[j - 1]); j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }
}

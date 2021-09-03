package com.algorithm.剑指offer;

import java.util.Arrays;

/**
 * @ClassName JZ40   最小的k个数
 * @Description TODO
 * @Author bill
 * @Date 2021/9/3 9:46
 * @Version 1.0
 **/
/*
最小的k个数
 */
public class JZ40 {
    public static void main(String[] args) {

    }

    //快排 + Arrays.copyOf
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (right <= left) {
            return;
        }
        int l = left, r = right;
        while (r > l) {
            while (r > l && arr[r] >= arr[left]) {
                r--;
            }
            while (r > l && arr[l] <= arr[left]) {
                l++;
            }
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
        int temp = arr[left];
        arr[left] = arr[l];
        arr[l] = temp;
        quickSort(arr, left, l - 1);
        quickSort(arr, l + 1, right);
    }

}

package com.algorithm.sort;

import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Description TODO
 * @Author bill
 * @Date 2021/7/11 10:41
 * @Version 1.0
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] test = new int[]{123, 435, 678, 2343, 6547, 65, 65, 867, 7, 3, 3, 525, 6532, 8, 585, 67};
        //quickSort(test, 0, test.length - 1);

        quickSort2(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
    }

    //先取 中间数 作为游标 left 和 right 作为其实和终点 开始遍历
    public static void quickSort(int[] arr, int left, int right) {
        int l = left, r = right;
        int pivot = arr[(right + left) / 2];
        while (r > l) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            //交换
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r)
            quickSort(arr, left, r);
        if (l < right)
            quickSort(arr, l, right);
    }

    public static void quickSort2(int[] arr, int low, int high) {
        if (low < high) {
            int part = partition(arr, low, high);
            quickSort2(arr, low, part - 1);
            quickSort2(arr, part + 1, high);
        }
    }

    //取第一个数作为 pivot
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            //1、从后往前 找到小于 pivot 的第一个数
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            //2、把这个数放到low位置 high位置空出
            arr[low] = arr[high];
            //3、从前往后 找到大于 pivot 的第一个数
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            //4、把这个数放到high位置 low位置空出
            arr[high] = arr[low];
            //循环直到 low 和 high 相遇
        }
        arr[low] = pivot;
        return low;
    }


    private void quickSort3(int[] arr, int l, int r) {
        // 子数组长度为 1 时终止递归
        if (l >= r) return;
        // 哨兵划分操作（以 arr[l] 作为基准数）
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        // 递归左（右）子数组执行哨兵划分
        quickSort3(arr, l, i - 1);
        quickSort3(arr, i + 1, r);
    }
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

package com.algorithm.sort;

import java.util.Arrays;

//归并排序
//https://www.cnblogs.com/chengxiao/p/6194356.html
public class MergeSort {
    public static void main(String[] args) {
        int[] test = {123, 435, 678, 2343, 6547, 65, 65, 867, 7, 3, 3, 525, 6532, 8, 585, 67};
        //mergeSort(test, 0, test.length - 1);
        //mergeSort(test);
        myMergeSort(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
    }

    //1、递归写法
    private static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        //把大的数组分隔成两个数组
        int mid = (start + end) / 2;
        //对左半部分进行排序
        mergeSort(nums, start, mid);
        //对右半部分进行排序
        mergeSort(nums, mid + 1, end);
        //进行合并
        merge(nums, start, mid, end);
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] tempNums = new int[nums.length];
        int i = start;
        int j = mid + 1;
        int k = start;
        while (i <= mid && j <= end) {
            // < > 调整升降序
            if (nums[i] < nums[j]) {
                tempNums[k++] = nums[i++];
            } else {
                tempNums[k++] = nums[j++];
            }
        }
        //剩下的
        while (i <= mid) {
            tempNums[k++] = nums[i++];
        }
        while (j <= end) {
            tempNums[k++] = nums[j++];
        }
        for (int m = start; m <= end; m++) {
            nums[m] = tempNums[m];
        }
    }

    ////2、非递归写法
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        // 子数组的大小分别为1，2，4，8...
        // 刚开始合并的数组大小是1，接着是2，接着4....
        for (int i = 1; i < n; i += i) {
            //进行数组进行划分
            int left = 0;
            int mid = left + i - 1;
            int right = mid + i;
            //进行合并，对数组大小为 i 的数组进行两两合并
            while (right < n) {
                // 合并函数和递归式的合并函数一样
                merge(arr, left, mid, right);
                left = right + 1;
                mid = left + i - 1;
                right = mid + i;
            }
            // 还有一些被遗漏的数组没合并，千万别忘了
            // 因为不可能每个字数组的大小都刚好为 i
            if (left < n && mid < n) {
                merge(arr, left, mid, n - 1);
            }
        }
    }

    //简化写法
    static void myMergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        int[] tmp = new int[right - left + 1];
        int idxL = left;
        int idxR = mid + 1;
        int idx = 0;
        while (idxL <= mid && idxR <= right) {
            if (nums[idxL] < nums[idxR]) {
                tmp[idx++] = nums[idxL++];
            } else {
                tmp[idx++] = nums[idxR++];
            }
        }
        //遍历 左边 剩下的
        while (idxL <= mid) {
            tmp[idx++] = nums[idxL++];
        }
        //遍历 右边 剩下的
        while (idxR <= right) {
            tmp[idx++] = nums[idxR++];
        }
        //有序数组赋值
        for (int i = 0; i < tmp.length; i++) {
            nums[i + left] = tmp[i];
        }
    }

}

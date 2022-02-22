package com.algorithm.sort;

/**
 * @ClassName Test2
 * @Description TODO
 * @Author bill
 * @Date 2022/2/13 21:48
 * @Version 1.0
 **/
public class Test2 {

    //冒泡
    //稳定 平均 O(n^2)  最坏 O(n^2)  最好 O(n)
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        //升序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    //插入
    //稳定 平均 O(n^2)  最坏 O(n^2)  最好 O(n)
    public void insertSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        //把第一个元素当成是排好序的 所以从第二个元素开始
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                //升序
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                } else {
                    break;
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

    //堆排序 todo
    //不稳定 平均 O(nlogn)  最坏 O(nlogn)  最好 O(nlogn)
    public void heapSort(int[] arr) {

    }

    //快排 升序
    //不稳定 平均 O(nlogn)  最坏 O(n^2)  最好 O(nlogn)
    //空间复杂度 O(nlogn)
    //时间: 最好情况每次递归都平分数组，一共需要递归logn次，每次需要n时间，复杂度为O(n*logn)，
    //      最坏情况(升序变降序)每次都把数组分成1和n-1，一共需要递归n次，每次需要n时间，总体复杂度为O(n^2)。
    //      平均总体时间复杂度为O(nlogn)。
    //空间: 和时间复杂度相关，每次递归需要的空间是固定的，总体空间复杂度即为递归层数，因此平均/最好空间复杂度为O(logn)，最坏空间复杂度为O(n)
    //尾递归 https://blog.csdn.net/zcyzsy/article/details/77151709
    public void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        //每次取 arr[left] 为 哨兵
        int l = left, r = right;
        while (l < r) {
            while (l < r && arr[r] >= arr[left]) {
                r--;
            }
            while (l < r && arr[l] <= arr[left]) {
                l++;
            }
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }
        int tmp = arr[l];
        arr[l] = arr[left];
        arr[left] = tmp;
        quickSort(arr, left, l - 1);
        quickSort(arr, l + 1, right);
    }


}

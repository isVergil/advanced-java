package com.algorithm.剑指offer;

/**
 * @ClassName JZ51
 * @Description TODO
 * @Author bill
 * @Date 2021/11/25 16:18
 * @Version 1.0
 **/
public class JZ51 {
    int res = 0;

    //归并排序
    public int reversePairs(int[] array) {
        mergeSort(array, 0, array.length - 1);
        return res;
    }

    public void mergeSort(int[] array, int left, int right) {
        //终止条件
        if (left >= right) {
            return;
        }
        //递归
        int mid = left + (right - left) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        int tmpleft = left, tmpmid = mid + 1;
        int index = 0;
        int[] tmparray = new int[right - left + 1];
        while (tmpleft <= mid && tmpmid <= right) {
            if (array[tmpleft] <= array[tmpmid]) {
                tmparray[index++] = array[tmpleft++];
            } else {
                res += (mid - tmpleft + 1);
                //res = ((mid - tmpleft + 1) + res) % 1000000007;
                tmparray[index++] = array[tmpmid++];
            }
        }
        //左边剩余的填入
        while (tmpleft <= mid) {
            tmparray[index++] = array[tmpleft++];
        }
        //右边剩余的填入
        while (tmpmid <= right) {
            tmparray[index++] = array[tmpmid++];
        }
        for (int i = 0; i < tmparray.length; i++) {
            array[left + i] = tmparray[i];
        }
    }
}

package com.algorithm.LeetCode热题HOT100;

import java.util.Arrays;

/**
 * @ClassName LC4
 * @Description TODO
 * @Author bill
 * @Date 2021/10/28 21:27
 * @Version 1.0
 **/
/*
 寻找两个正序数组的中位数
判断奇偶 (len & 1) == 0

https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-s-114/
 */
public class LC4 {

    //标准答案
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }

    //比较土的解法
    public double findMedianSortedArrays1(int[] A, int[] B) {
        int[] newArr = new int[A.length + B.length];
        int i = 0;
        for (int item : A) {
            newArr[i++] = item;
        }
        for (int item : B) {
            newArr[i++] = item;
        }
        Arrays.sort(newArr);
        if (newArr.length % 2 == 0) {
            return (newArr[newArr.length / 2] + newArr[newArr.length / 2 - 1]) / 2.0;
        } else {
            return newArr[newArr.length / 2];
        }
    }

    //个人理解的解法
    //两个有序的只需要遍历 (lenA + lenB) / 2 次就可求出中位数
    //注意遍历的条件    (aIndex < aLen && (bIndex >= bLen || A[aIndex] < B[bIndex]))
    public double findMedianSortedArrays2(int[] A, int[] B) {
        int aIndex = 0, bIndex = 0;
        int aLen = A.length;
        int bLen = B.length;
        int len = aLen + bLen;
        int left = 0;
        int right = 0;
        //有序遍历这两个数组
        for (int i = 0; i < len / 2; i++) {
            left = right;
            if (aIndex < aLen && (bIndex >= bLen || A[aIndex] < B[bIndex])) {
                right = A[aIndex++];
            } else {
                right = B[bIndex++];
            }
        }
        //偶数
        if ((len & 1) == 0) {
            return (left + right) / 2;
        }
        //奇数
        return right;
    }
}

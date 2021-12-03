package com.internship.bytedance;

/**
 * @ClassName LC_1574
 * @Description TODO
 * @Author bill
 * @Date 2021/9/8 10:39
 * @Version 1.0
 **/
/*
删除最短的子数组使剩余数组有序
给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。

一个子数组指的是原数组中连续的一个子序列。
请你返回满足题目要求的最短子数组的长度。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        //判断条件，可以不要
        if(arr == null || arr.length == 1){
            return 0;
        }

        int n = arr.length;
        int left = 0;
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }
        // [0...left]有序
        if (left == n - 1) {
            return 0;
        }
        // [right...n-1]有序
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        // 完全删除一边[left+1, n-1], 或者[0...right - 1]
        int result = Math.min(n - left - 1, right);

        // 左边和右边各保留一部分
        int i = 0, j = right;

        while (i <= left && j <= n - 1) {
            if (arr[i] <= arr[j]) {
                // [0...i] 和 [j...n-1] 有序, 删除 [i+1...j-1]
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                // 小的+1
                j++;
            }
        }
        return result;
    }


    //第二种思路
    public int findLengthOfShortestSubarray1(int[] arr) {
        int len = arr.length;
        int left = 1;
        while (left < len && arr[left] >= arr[left - 1]) {
            left++;
        }
        if (left == len) {
            return 0;
        }
        int right = len - 1;
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }
        int result = right - left;
        int i = 0, j = right;
        while (i < left && j <= len - 1) {
            if (arr[i] > arr[j]) {
                j++;
                result++;
            }
            i++;
        }
        return result;
    }
}

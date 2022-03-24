package com.algorithm.LeetCode热题HOT100;

/**
 * @ClassName LC31
 * @Description 31. 下一个排列
 * @Author bill
 * @Date 2022/3/20 16:13
 * @Version 1.0
 **/
public class LC31 {

    /*
       [...,i,j,...,end]
         1、首先从后 end 向前查找第一个相邻升序的元素对 (i,j)
         2、然后在 [j,end) 从后向前查找第一个大于 A[i] 的值 A[k]
         3、将 A[i] 与 A[k] 交换 确定高位
         4、这时 [j,end) 必然是降序，逆置 [j,end)，使其升序，即为最小。
     */
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        int j = len - 1;
        int k = len - 1;
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }//从后往前找
        if (i >= 0) {//不是最后一个序列
            while (nums[i] >= nums[k]) {
                k--;
            }
            swap(nums, i, k);
        }
        reverse(nums, j, len - 1);
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }

    public void reverse(int[] nums, int a, int b) {
        while (a < b) {
            swap(nums, a++, b--);
        }
    }

}

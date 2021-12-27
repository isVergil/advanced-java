package com.algorithm.剑指offer;

/**
 * @ClassName JZ53
 * @Description TODO
 * @Author bill
 * @Date 2021/11/14 10:46
 * @Version 1.0
 **/
/*
JZ53 数字在升序数组中出现的次数

给定一个长度为 n 的非降序数组和一个非负数整数 k ，要求统计 k 在数组中出现的次数

数据范围：0 \le n \le 1000 , 0 \le k \le 1000≤n≤1000,0≤k≤100，数组中每个元素的值满足 0 \le val \le 1000≤val≤100
要求：空间复杂度 O(1) ，时间复杂度 O(logn)
 */
public class JZ53 {

    //二分法 保证时间复杂度是 O(logn)
    public int GetNumberOfK(int[] array, int k) {
//         int count = 0;
//         for(int item : array){
//             if(k == item){
//                 count++;
//             }
//         }
//         return count;
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0, right = array.length;
        while (right > left) {
            int mid = (left + right) / 2;
            if (array[mid] < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int leftFlag1 = left;
        left = 0;
        right = array.length;
        while (right > left) {
            int mid = (left + right) / 2;
            if (array[mid] <= k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int leftFlag2 = left;
        return leftFlag2 - leftFlag1;
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int rightFlag = right;
        left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return rightFlag - right;
    }

    //优化
    public int search1(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        //初始左右指针位置
        int i = 0;
        int j = nums.length - 1;
        //第一次二分：找right边界
        //这边是“小于等于”，因此当循环结束后，ij不重合，且如果存在target值的话，i的位置就是右边界（target值序列右边第一个大于target值的位置），因为最后一次循环一定是i=mid+1；且此时j指向target
        while (i <= j) {
            int mid = (i + j) >> 1;
            //这里是“小于等于”，目的是为了确定右边界，就是说当mid等于target时，因为不确定后面还有没有target，所以同样需要左边收缩范围
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        //在更新right边界值之前，需要判断这个数组中是否存在target，如果不存在（看j指向的位置是不是target，为什么看的是j指针？详见上面的注释）
        if (j >= 0 && nums[j] != target) {
            return 0;
        }
        int right = i;    //更新right边界
        //重置指针
        i = 0;
        j = nums.length - 1;
        //第二次二分：找left边界
        //结束之后，j指向target序列左边第一个小于它的位置，i指向target（经过上面判断，target一定存在）
        while (i <= j) {
            int mid = (i + j) >> 1;
            //这里是“大于等于”，目的是确定左边界，因为就算当mid等于target的时候，因为不确定左边还有没有target，所以同样需要收缩右边界
            if (nums[mid] >= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        //更新左指针
        int left = j;
        return right - left - 1;
    }
}

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
}

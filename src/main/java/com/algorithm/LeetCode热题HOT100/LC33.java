package com.algorithm.LeetCode热题HOT100;

/**
 * @ClassName LC33
 * @Description 33. 搜索旋转排序数组
 * @Author bill
 * @Date 2022/3/22 16:27
 * @Version 1.0
 **/
public class LC33 {


    //将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
    //此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
    public int search(int[] nums, int target) {
        int left = 0, len = nums.length, right = len - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (target == nums[mid]) {
                return mid;
            }
            //0 ~ mid 是单增序列
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {   //0 ~ mid 不是单增序列
                if (nums[mid] < target && target <= nums[len - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

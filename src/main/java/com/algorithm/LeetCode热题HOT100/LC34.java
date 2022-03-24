package com.algorithm.LeetCode热题HOT100;

/**
 * @ClassName LC34
 * @Description 34. 在排序数组中查找元素的第一个和最后一个位置
 * @Author bill
 * @Date 2022/3/22 16:55
 * @Version 1.0
 **/
public class LC34 {
    //法1 寻找到 左边界 再往右++ 寻找右边界
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int flag = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                flag = mid;
                break;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (flag == -1) {
            return new int[]{-1, -1};
        }
        l = flag;
        r = flag;
        while (l >= 0 && r < nums.length && nums[l] == target && nums[r] == target) {
            while (l >= 0 && nums[l] == target) {
                l--;
            }
            while (r < nums.length && nums[r] == target) {
                r++;
            }
        }
        return new int[]{l + 1, r - 1};
    }


    //法2  注意二分法的边界条件
    public int[] searchRange1(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        if (nums == null || nums.length == 0 || nums[0] > target || nums[r] < target) {
            return new int[] {-1 , -1};
        }
        int left = findTargetLeft(nums, target);
        if (nums[left] != target) {
            return new int[] {-1 , -1};
        }
        int right = findTargetRight(nums, target);
        return new int[] {left, right};
    }

    //找出小于等于target的第一个
    public int findTargetLeft (int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r + 1;
    }

    //找出小于等于target的最后一个
    public int findTargetRight (int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l - 1;
    }
}

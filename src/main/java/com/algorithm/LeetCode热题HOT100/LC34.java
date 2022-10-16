package com.algorithm.LeetCode热题HOT100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
            return new int[]{-1, -1};
        }
        int left = findTargetLeft(nums, target);
        if (nums[left] != target) {
            return new int[]{-1, -1};
        }
        int right = findTargetRight(nums, target);
        return new int[]{left, right};
    }

    //找出小于等于target的第一个
    public int findTargetLeft(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    //找出小于等于target的最后一个
    public int findTargetRight(int[] nums, int target) {
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

    public static void main(String[] args) {
        // int[] nums = {2, 3, 5, 5, 5, 6, 6, 7, 8, 9};
        // System.out.println(Arrays.toString(nums));
        // // System.out.println(new LC34().findTargetLeft(nums, 5));
        // // System.out.println(new LC34().findTargetRight(nums, 5));
        //
        // System.out.println(new LC34().bsearch_1(0, nums.length - 1, nums, 4));
        // System.out.println(new LC34().bsearch_2(0, nums.length - 1, nums, 1));

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dis = new int[n];
        int r = 0;
        for (int i = 0; i < dis.length; i++) {
            dis[i] = sc.nextInt();
            r = Math.max(r, dis[i]);
        }
        Arrays.sort(dis);
        int l = 0;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid, dis, m)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(l);

    }

    static boolean check(int maxDis, int[] dis, int m) {
        int cnt = 1, prev = dis[0];
        for (int i = 1; i < dis.length; i++) {
            if (dis[i] - prev >= maxDis) {
                cnt++;
                prev = dis[i];
            }
        }
        return cnt >= m;
    }

    // >= target 的第一个
    // 区间[left, right]被划分成[left, mid]和[mid + 1, right]时使用
    int bsearch_1(int left, int right, int[] nums, int target) {
        while (left < right) {
            int mid = left + right >> 1;
            if (nums[mid] >= target) {
                right = mid;    // check()判断mid是否满足性质
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // >= target 的最后一个
    // 区间[left, right]被划分成[left, mid - 1]和[mid, right]时使用
    int bsearch_2(int left, int right, int[] nums, int target) {
        while (left < right) {
            int mid = left + right + 1 >> 1;    // 注意这里要+1
            if (nums[mid] >= target) {  // check()判断mid是否满足性质
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}

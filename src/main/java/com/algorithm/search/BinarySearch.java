package com.algorithm.search;

import java.util.Arrays;

/**
 * @ClassName BinarySearch
 * @Description TODO
 * @Author bill
 * @Date 2021/7/7 21:28
 * @Version 1.0
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = {3, 3, 7, 8, 65, 67, 123, 435, 525, 585, 678, 867, 2343, 6547};
        System.out.println(Arrays.toString(numbers));

        System.out.println(myBinarySearch(numbers, 123));

        System.out.println(numbers[myBinarySearch(numbers, 123)]);
    }

    private static int myBinarySearch(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] == target) {
                return mid;
            }
            if (numbers[mid] > target) {
                right = mid - 1;
            }
            if (numbers[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }


}

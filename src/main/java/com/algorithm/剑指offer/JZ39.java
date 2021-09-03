package com.algorithm.剑指offer;

/**
 * @ClassName JZ39   数组中出现次数超过一半的数字
 * @Description TODO
 * @Author bill
 * @Date 2021/9/3 9:46
 * @Version 1.0
 **/
/*
数组中出现次数超过一半的数字
 */
public class JZ39 {
    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            votes += num == x ? 1 : -1;
        }
        return x;
    }

}

package com.algorithm.leetcode;

/**
 * @ClassName LC260
 * @Description TODO
 * @Author bill
 * @Date 2021/8/18 9:10
 * @Version 1.0
 **/
public class LC260 {
    public static void singleNumber(int[] array) {
        // write code here
        int[] result = new int[2];
        int temp = 0, right1 = 0;
        for (int item : array) {
            temp ^= item;
        }
        right1 = temp & (-temp);
        for (int item : array) {
            System.out.println(item + "&" + right1 + "=" + (item & right1));
            if ((item & right1) == 1) {
                System.out.println("0:" + item);
                result[0] ^= item;
            } else {
                System.out.println("1:" + item);
                result[1] ^= item;
            }
        }
        System.out.println(result[0] + ":" + result[1]);
    }

    public static void main(String[] args) {
        singleNumber(new int[]{1, 2, 1, 3, 2, 5});


    }
}

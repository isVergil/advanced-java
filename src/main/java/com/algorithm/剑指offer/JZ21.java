package com.algorithm.剑指offer;


/**
 * @ClassName JZ13
 * @Description TODO
 * @Author bill
 * @Date 2021/8/30 15:31
 * @Version 1.0
 **/

/*
 调整数组顺序使奇数位于偶数前面

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。


 */
public class JZ21 {

    public static void main(String[] args) {

    }

    //奇数放前面，偶数放后面
    //前后指针
    public int[] exchange(int[] array) {
        if (array == null || array.length == 1) {
            return array;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            //while(left < array.length && array[left] % 2 != 0){
            while (left < right && array[left] % 2 == 1) {
                left++;
            }
            //while(right >= 0 && array[right] % 2 == 0){
            while (left < right && array[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                //交换
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        return array;
    }

    //保证各个奇偶数相对位置不变
    public int[] reOrderArray(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int[] res = new int[array.length];
        int left = 0, right = array.length - 1, len = array.length;
        int newleft = 0, newright = right;
        int index = 0;
        while (left < len && right >= 0) {
            if (array[left] % 2 != 0) {
                res[newleft++] = array[left];
            }
            left++;
            if (array[right] % 2 == 0) {
                res[newright--] = array[right];
            }
            right--;
        }
        return res;
    }

}

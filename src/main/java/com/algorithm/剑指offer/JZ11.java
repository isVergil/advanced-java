package com.algorithm.剑指offer;

/**
 * @ClassName JZ11
 * @Description TODO
 * @Author bill
 * @Date 2021/8/29 14:46
 * @Version 1.0
 **/
/*
旋转数组的最小数字

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


 */
public class JZ11 {

    public static void main(String[] args) {

    }

    //方法1
    //从前往后找到第一个元素大于后一个元素的值即为所求
    public int minArray1(int[] numbers) {
        int result = numbers[0];    //防止所有元素都相等
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]) {
                return numbers[i];
            }
        }
        return result;
    }

    //方法2  伪二分查找
    //从前往后找到第一个元素大于后一个元素的值即为所求
    public int minArray2(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

}

package com.algorithm.剑指offer;

/**
 * @ClassName JZ67
 * @Description TODO
 * @Author bill
 * @Date 2021/9/18 15:28
 * @Version 1.0
 **/
/*
 把字符串转换成整数
 */
public class JZ67 {
    public int strToInt(String str) {
        char[] strArr = str.trim().toCharArray();
        if (strArr.length == 0) {
            return 0;
        }
        int res = 0, max = Integer.MAX_VALUE / 10;    //是否越界判断 这是最大元素前一个的最小值
        int i = 1, sign = 1;
        if (strArr[0] == '-') {             //考虑负数的情况
            sign = -1;
        } else if (strArr[0] != '+') {     //注意是首元素 不等于 '+' 则从下标 0 开始遍历
            i = 0;
        }
        for (int j = i; j < strArr.length; j++) {
            if (strArr[j] < '0' || strArr[j] > '9') {
                break;
            }
            //记住就行
            //不能直接向int变量赋值-2147483648，
            //-2147483648是一个常量表达式而非常量，系统会把它分成两部分，即负号 - 和 数字 2147483648，因此会出现越界的情况。
            if (res > max || res == max && strArr[j] > '7') {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            res = res * 10 + (strArr[j] - '0');
        }
        return sign * res;
    }
}

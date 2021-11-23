package com.algorithm.剑指offer;

/**
 * @ClassName JZ46
 * @Description TODO
 * @Author bill
 * @Date 2021/11/22 16:23
 * @Version 1.0
 **/
/*
 把数字翻译成字符串
 */
public class JZ46 {

    /*
     ****************leetcode 输入是 int 0 -25  a - z
     */
    //法1 简单递归
    public int translateNum1(int num) {
        if (num <= 9) {
            return 1;
        }
        int tmp = num % 100;
        if (tmp < 10 || tmp > 25) {
            return translateNum1(num / 10);
        } else {
            return translateNum1(num / 10) + translateNum1(num / 100);
        }
    }

    //法2 动态规划  0 -25
    public int translateNum2(int num) {
        //最好是弄成字符
        String str = String.valueOf(num);
        int[] dp = new int[str.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        String tmp = "";
        for (int i = 2; i <= str.length(); i++) {
            tmp = str.substring(i - 2, i);
            //这两位字符可以看成 2 种数字 即 dp[i] = dp[i - 1] + dp[i - 2]
            if (tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[str.length()];
    }

    //法2.2 动态规划 优化(主要是变量的优化)  0 -25
    public int translateNum3(int num) {
        //最好是弄成字符
        String str = String.valueOf(num);
        int a = 1;
        int b = 1;
        int res = 1;
        String tmp = "";
        for (int i = 2; i <= str.length(); i++) {
            tmp = str.substring(i - 2, i);
            //这两位字符可以看成 2 种数字 即 dp[i] = dp[i - 1] + dp[i - 2]
            if (tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0) {
                res = a + b;
            } else {
                res = b;
            }
            a = b;
            b = res;
        }
        return res;
    }


    /*
     ****************牛客 输入是 String 1 -26  a - z
     */
    public int solve(String nums) {
        if (nums == null || nums.length() == 0 || nums.charAt(0) == '0') {
            return 0;
        }
        char[] arr = nums.toCharArray();
        int[] dp = new int[nums.length()];
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            //大多数情况   21（可以翻译为 2 个）  99
            dp[i] = dp[i - 1];
            //10 或者 00
            if (arr[i] == '0') {
                //出现两个相邻的 0  无法翻译直接返回 0
                if (arr[i - 1] == '0') {
                    return 0;
                }
                //大于 10 的情况
            } else {
                //11 --- 26
                if (arr[i - 1] == '1' || (arr[i - 1] == '2' && arr[i] < '7')) {
                    //11
                    if (i == 1) {
                        dp[i] += 1; //11的情况 2 种
                        //12 --- 26
                    } else {
                        dp[i] += dp[i - 2];
                    }
                }
            }
        }
        return dp[nums.length() - 1];

    }


}

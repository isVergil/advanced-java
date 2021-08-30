package com.algorithm.剑指offer;


/*
青蛙跳台阶问题

一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class JZ10_2 {
    public static void main(String[] args) {

    }

    //动态规划
    //跳上0级台阶 f0 = 1 种 （题意）
    //跳上1级台阶 f1 = 1 种
    //跳上2级台阶 f2 = 2 种
    //跳上3级台阶 f3 = f1 + f2 = 3 种
    public int numWays(int n) {
        int f0 = 1, f1 = 1;
        int result = 1;
        while (n-- > 1) {
            result = (f0 + f1) % 1000000007;
            f0 = f1;
            f1 = result;
        }
        return result;
    }


}

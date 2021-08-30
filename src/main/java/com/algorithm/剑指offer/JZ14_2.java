package com.algorithm.剑指offer;

/**
 * @ClassName JZ13
 * @Description TODO
 * @Author bill
 * @Date 2021/8/30 15:31
 * @Version 1.0
 **/

/*
剪绳子 II

给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。
请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class JZ14_2 {

    public static void main(String[] args) {

    }

    //让 3 最多
    //快速幂求余，让每次乘积之后求下 余
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int count = n / 3;
        long result = 1;
        while (--count > 0) {
            result = result * 3 % 1000000007;
        }
        if (n % 3 == 0) {
            return (int) (result * 3 % 1000000007);
        } else if (n % 3 == 1) {
            return (int) (result * 4 % 1000000007);
        } else {
            return (int) (result * 6 % 1000000007);
        }
    }
}

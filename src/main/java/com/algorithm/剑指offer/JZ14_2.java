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

    //如何快速计算3的cnt次幂?
    public long pow(long cnt) {
        if (cnt == 0) {
            return 1;
        }
        if (cnt == 1) {
            return 3;
        }
        long part = pow(cnt / 2);
        if (cnt % 2 == 0) {
            return part * part % 998244353;
        }
        return 3 * part * part % 998244353;
    }

    //快速幂 将 乘积次数 从n次 降到lgn次
    //https://zhuanlan.zhihu.com/p/95902286
    //1、递归 快速幂
    public long pow1(long a, long n) {
        if (n == 0) {
            return 1;
        } else if (n % 2 == 1) {
            return pow1(a, n - 1) * a;
        } else {
            long tmp = pow1(a, n / 2);
            return tmp * tmp;
        }
    }

    //1.1
    double power(double base, int exponent) {
        if (exponent == 0) {
            return 1.0;
        }
        double res = power(base, exponent / 2);
        if ((exponent & 1) != 0) {
            return res * res * base;
        } else {
            return res * res;
        }
    }

    //2、非递归 快速幂
    //幂 表示为 2 进制数，当前位为1 即 要 *= 当前位表示的十进制数
    public long pow2(long a, long n) {
        if (n == 0) {
            return 1;
        }
        long res = 1;
        if (n < 0) {
            n = -n;
            a = 1 / a;
        }
        while (n > 0) {
            if ((n & 1) == 1) {
                res *= a;
            }
            a *= a;
            n >>= 1;
        }
        return res;
    }
}

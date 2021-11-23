package com.algorithm.剑指offer;

/**
 * @ClassName Bitwise
 * @Description TODO
 * @Author bill
 * @Date 2021/11/15 16:01
 * @Version 1.0
 **/
//位运算总结
public class Bitwise {

    //n&(n-1)   3个作用
    //将n的二进制表示中的最低位(最右边)为1的改为0
    public void test() {
        int n = 100;
        int count = 0;
        //1、求某一个数的二进制表示中1的个数
        while (n > 0) {
            count++;
            n &= (n - 1);
        }
        //2、判断一个数是否是2的方幂
        if(n > 0 && ((n & (n - 1)) == 0 )){
            System.out.println("是2的方幂");
        }
        //3、不太常用
    }

    //求出二进制数最右边为 1 的位置
    //m = n & (~n + 1);
    //m = n - (n & (n - 1))
}

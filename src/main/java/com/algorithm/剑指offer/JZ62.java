package com.algorithm.剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JZ62
 * @Description TODO
 * @Author bill
 * @Date 2021/9/19 15:10
 * @Version 1.0
 **/
/*
圆圈中最后剩下的数字

0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JZ62 {

    //法1 递归
    public int lastRemaining(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = lastRemaining(n - 1, m);
        return (m + x) % n;
    }

    //法2 迭代 公式迭代
    //res 表示索引号
    public int lastRemaining1(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }

    //常规思路  模拟链表
    //定义一个链表结构的环，每次删除第m的节点
    //优化：使用 ArrayList 这种结构来模拟约瑟夫环
    public int lastRemaining33(int n, int m) {
        List<Integer> list = new ArrayList<>();
        //将元素存入
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        //剩余元素大于 1 就循环删除第 m 个节点
        while (n > 1) {
            //要删除的节点位置 约瑟夫环是从 0 - n-1 因此 要 （当前位置 +  m - 1）
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        //返回剩余的一个元素即所求
        return list.get(0);
    }
}

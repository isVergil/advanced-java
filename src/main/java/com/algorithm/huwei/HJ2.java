package com.algorithm.huwei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName HJ2
 * @Description HJ2 计算某字符出现次数
 * @Author bill
 * @Date 2022/6/18 23:12
 * @Version 1.0
 **/
public class HJ2 {
    /*
    写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
    数据范围： 1 \le n \le 1000 \1≤n≤1000
    输入描述：
    第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。
    输出描述：
    输出输入字符串中含有该字符的个数。（不区分大小写字母）
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] strs = br.readLine().toLowerCase().toCharArray();
        char[] chars = br.readLine().toLowerCase().toCharArray();
        int res = 0;
        for (char ch : strs) {
            if (ch == chars[0]) {
                res++;
            }
        }
        System.out.println(res);

    }
}

package com.algorithm.huwei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName HJ4
 * @Description HJ4 字符串分隔
 * @Author bill
 * @Date 2022/6/18 23:37
 * @Version 1.0
 **/
public class HJ4 {
    /*
    •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
    •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
    输入描述：
    连续输入字符串(每个字符串长度小于等于100)
    输出描述：
    依次输出所有分割后的长度为8的新字符串
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        while (str.length() >= 8) {
            System.out.println(str.substring(0, 8));
            str = str.substring(8);
        }
        if (str.length() > 0 && str.length() < 8) {
            String tmp = "00000000";
            str += tmp;
            System.out.println(str.substring(0, 8));
        }
    }
}

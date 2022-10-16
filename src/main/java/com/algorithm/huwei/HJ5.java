package com.algorithm.huwei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HJ5
 * @Description HJ5 进制转换
 * @Author bill
 * @Date 2022/6/19 0:07
 * @Version 1.0
 **/
public class HJ5 {
    static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);
    }

    /*
       写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
        输入一个十六进制的数值字符串。
        输出该数值的十进制字符串。不同组的测试用例用\n隔开。
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String num = str.substring(2);
        int result = 0;
        int power = 1;
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (c >= '0' && c <= '9') {
                result += (c - '0') * power;
            } else if (c >= 'A' && c <= 'F') {
                result += (c - 'A' + 10) * power;
            }
            power *= 16;
        }
        System.out.println(result);

    }

    void main2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            System.out.println(Long.parseLong(str.substring(2), 16));
        }
    }

}

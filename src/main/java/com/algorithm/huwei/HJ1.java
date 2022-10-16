package com.algorithm.huwei;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @ClassName HJ1
 * @Description HJ1 字符串最后一个单词的长度
 * @Author bill
 * @Date 2022/6/18 22:54
 * @Version 1.0
 **/
public class HJ1 {

    //计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
    //输入：hello nowcoder
    //输出：8
    //说明：最后一个单词为nowcoder，长度为8
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(" ", 0);
        if (strs.length == 0) {
            System.out.println(0);
            return;
        }
        System.out.println(strs[strs.length - 1].length());
    }

    public static void main1() throws IOException {
        InputStream inputStream = System.in;
        int length = 0;
        char c = (char) inputStream.read();
        while (c != '\n') {
            length++;
            if (c == ' ') {
                length = 0;
            }
            c = (char) inputStream.read();
        }
        inputStream.close();
        System.out.println(length);
    }

}

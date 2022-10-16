package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @ClassName InOutPut
 * @Description TODO
 * @Author bill
 * @Date 2022/4/12 16:10
 * @Version 1.0
 **/
public class InOutPut {
    public static void main(String[] args) throws IOException {

        //System.out.println(scTest());
        brTest();

    }

    /***
     1
     2
     34
     37
     */
    //以两个 Scanner 作为输入，第一个 Scanner 的下一行作为 第二个 Scanner 的构造输入
    static int scTest() {
        Scanner sc = new Scanner(System.in);
        String l = sc.nextLine();
        Scanner scan_l = new Scanner(l);
        int res = 0;
        while (scan_l.hasNextInt()) {
            int cur = scan_l.nextInt();
            System.out.println(cur);
            res += cur;
        }
        return res;
    }


    static int brTest() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cur;
        while (!(cur = br.readLine()).isEmpty()) {
            // String cur = br.readLine();
            // if (cur == null || cur.isEmpty()) {
            //     break;
            // }
            System.out.println(cur);
        }
        return -1;
    }
}

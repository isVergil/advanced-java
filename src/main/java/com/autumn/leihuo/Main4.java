package com.autumn.leihuo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Main4
 * @Description TODO
 * @Author bill
 * @Date 2022/9/18 20:59
 * @Version 1.0
 **/
public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int res = 0;
        List<Integer> map = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            int i = sc.nextInt();
            if (!map.contains(i)) {
                map.add(i);
            }
            int x = sc.nextInt();
            int y = sc.nextInt();
            int coin = sc.nextInt();
            res += coin;
        }
        for (int j = 0; j < m; j++) {
            int i = sc.nextInt();
            if (!map.contains(i)) {
                map.add(i);
            }
            int x = sc.nextInt();
            int y = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int coin = sc.nextInt();
            res += coin;
        }
        int C = sc.nextInt();
        int D = sc.nextInt();
        System.out.println(res + map.size() * C);
    }
}

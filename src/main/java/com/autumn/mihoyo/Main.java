package com.autumn.mihoyo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Main
 * @Description TODO
 * @Author bill
 * @Date 2022/9/14 19:45
 * @Version 1.0
 **/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        String target = "mihoyo";
        if (!s.contains(target) || n < k * 6) {
            System.out.println(-1);
        } else {
            if (k == 1) {
                System.out.println(s.indexOf(target) + " " + s.indexOf(target) + 5);
            } else {
                //查询每个 target 出现的位置
                List<Integer> findIndex = new ArrayList<>();
                String cur = s;
                int idx = 0;
                while (cur.contains(target)) {
                    idx += cur.indexOf(target);
                    findIndex.add(idx);
                    idx += 6;
                    cur = s.substring(idx);
                }
                if (findIndex.size() < k) {
                    System.out.println(-1);
                    return;
                }
                int start = findIndex.get(0);
                int end = findIndex.get(0);
                int res = (int) 1e7;
                for (int i = 0; i < findIndex.size() - k; i++) {
                    int curLen = findIndex.get(i + k - 1) - findIndex.get(i) + 5;
                    if (curLen < res) {
                        res = curLen;
                        start = findIndex.get(i);
                        end = curLen + start;
                    }
                }
                if (res > n) {
                    System.out.println(-1);
                    return;
                }
                System.out.println(start + " " + end);

            }

        }

    }

}

package com.autumn.yuanfudao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName Main
 * @Description TODO
 * @Author bill
 * @Date 2022/8/26 19:25
 * @Version 1.0
 **/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        while (M-- > 0) {
            int N = sc.nextInt();
            String[] cur = new String[N];
            for (int i = 0; i < N; i++) {
                cur[i] = sc.next();
            }
            int K = sc.nextInt();
            String[] kArr = new String[K];
            for (int i = 0; i < K; i++) {
                kArr[i] = sc.next();
            }
            System.out.println(cal(cur, kArr));
        }
    }

    static public int cal(String[] nArr, String[] kArr) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < nArr.length; i++) {
            String cur = nArr[i].toLowerCase();
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        int res = 0;
        for (String s : map.keySet()) {
            boolean f = false;
            for (String s1 : kArr) {
                s1 = s1.toLowerCase();
                if (s1.length() == s.length()) {
                    if (s1.equals(s)) {
                        f = true;
                        break;
                    } else {
                        boolean flag = true;
                        for (int i = 0; i < s.length(); i++) {
                            if (s1.charAt(i) != '?' && s.charAt(i) != s1.charAt(i)) {
                                flag = false;
                                break;
                            }
                        }
                        if (!flag) {
                            res = Math.max(res, map.get(s));
                        }
                    }
                }
            }
            if (!f) {
                res = Math.max(res, map.get(s));
            }
        }
        return res;
    }
}

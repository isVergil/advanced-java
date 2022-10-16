package com.algorithm.bytedance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @ClassName Test
 * @Description TODO
 * @Author bill
 * @Date 2022/7/15 12:20
 * @Version 1.0
 **/
public class Test {

    //1 万万没想到之聪明的编辑
    //public static void main(String[] args) throws IOException {
    //    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //    int N = Integer.parseInt(br.readLine());
    //    String[] strs = new String[N];
    //    for (int i = 0; i < strs.length; i++) {
    //        strs[i] = br.readLine();
    //    }
    //    for (String s : strs) {
    //        solve(s);
    //    }
    //}
    //
    //static void solve(String s) {
    //    if (s == null || s.length() == 0) {
    //        return;
    //    }
    //    if (s.length() < 3) {
    //        System.out.println(s);
    //        return;
    //    }
    //    //超过3个相同的去除重复
    //    for (int i = 0; i <= s.length() - 3; ) {
    //        String template = "" + s.charAt(i) + s.charAt(i) + s.charAt(i);
    //        if (s.substring(i, 3 + i).equals(template)) {
    //            s = s.substring(0, i + 1) + s.substring(i + 2);
    //            if (i + 2 == s.length()) {
    //                break;
    //            }
    //            continue;
    //        }
    //        i++;
    //    }
    //    for (int i = 0; i <= s.length() - 4; ) {
    //        String cur = s.substring(i, i + 4);
    //        if (cur.charAt(0) == cur.charAt(1) && cur.charAt(2) == cur.charAt(3)) {
    //            s = s.substring(0, i + 3) + s.substring(i + 4);
    //            if (i + 3 == s.length()) {
    //                break;
    //            }
    //            continue;
    //        }
    //        i++;
    //    }
    //    System.out.println(s);
    //}

    //2 万万没想到之抓捕孔连顺
    //public static void main(String[] args) {
    //    Scanner sc = new Scanner(System.in);
    //    int N = sc.nextInt();
    //    int D = sc.nextInt();
    //    int[] position = new int[N];
    //    for (int i = 0; i < position.length; i++) {
    //        position[i] = sc.nextInt();
    //    }
    //    long res = 0;
    //    //固定首位，确定末尾，排列组合公式计算
    //    //1 2 3 4
    //    for (int begin = 0, end = 0; end < N; end++) {
    //        while (end >= 2 && position[end] - position[begin] > D) {
    //            begin++;
    //        }
    //        res += C(end - begin);
    //    }
    //    System.out.println(res % 99997867);
    //}
    //
    //static long C(long n) {
    //    return n * (n - 1) / 2;
    //}

    //3 雀魂启动！

    static Map<Integer, Integer> map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new HashMap<>();
        for (int i = 0; i < 13; i++) {
            int cur = sc.nextInt();
            map.put(sc.nextInt(), map.getOrDefault(cur, 0) + 1);
        }
        for (int i = 1; i <= 9; i++) {
            if (map.get(i) == 4) {
                continue;
            }
            if (isHu()) {

            }
        }

    }

    //回溯
    public static boolean isHu() {
        return false;
    }


}

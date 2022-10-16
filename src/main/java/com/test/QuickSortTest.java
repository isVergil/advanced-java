package com.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName QuickSortTest
 * @Description TODO
 * @Author bill
 * @Date 2022/9/14 14:50
 * @Version 1.0
 **/
public class QuickSortTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        sc.nextLine();
        String[] zhu = sc.nextLine().split(" ");
        set1 = new HashSet<>();
        for (String s : zhu) {
            set1.add(s);
        }
        String[] wei = sc.nextLine().split(" ");
        set2 = new HashSet<>();
        for (String s : wei) {
            set2.add(s);
        }
        String[] bin = sc.nextLine().split(" ");
        set3 = new HashSet<>();
        for (String s : bin) {
            set3.add(s);
        }
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            if (slove(sc.nextLine())) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static Set<String> set1;
    static Set<String> set2;
    static Set<String> set3;

    static boolean slove(String curStr) {
        String[] str = curStr.split(" ");
        if (!set1.contains(str[0])) {
            return false;
        }
        int l = 0, r = str.length;
        //只包含主语
        while (l < r && set1.contains(str[l])) {
            l++;
        }
        if (l == r) {  //只包含主语
            return false;
        }
        int tmpL = l;
        //包含谓语
        while (l < r && set2.contains(str[l])) {
            l++;
        }
        if (l == tmpL) {  //不包含谓语
            return false;
        }
        if (l == r) {
            return true;
        }
        tmpL = l;
        while (l < r && set3.contains(str[l])) {
            l++;
        }
        if (tmpL == l) {
            return false;
        }
        return l == r;
    }

}

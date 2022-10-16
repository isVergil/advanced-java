package com.autumn.zoom;

import java.util.*;

/**
 * @ClassName Zoom_20220810
 * @Description TODO
 * @Author bill
 * @Date 2022/8/10 19:41
 * @Version 1.0
 **/
public class Zoom_20220810 {
    //https://www.jianshu.com/p/3a1d5cecfbe5

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //初始化数组
        init(n);
        val = new int[n][2];
        colors = sc.next();
        for (int i = 1; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x == 1) {
                union(x, y);
            } else {
                union(y, x);
            }
        }
        int res = 0;
        for (int[] v : val) {
            res += Math.abs(v[0] - v[1]);
        }
        System.out.println(res);
    }

    static String colors;

    static int[][] val;

    static int[] parent;

    //初始化
    static void init(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    //查询 x 的 根节点
    static int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    //合并,把 j 合并到 i 中去，就是把j的双亲结点设为i
    static void union(int i, int j) {
        int x = find(j - 1);
        int y = find(i - 1);
        if (colors.charAt(y) == 'R') {
            val[j - 1][0]++;
        } else {
            val[j - 1][1]++;
        }
        if (colors.charAt(j - 1) == 'R') {
            val[j - 1][0]++;
        } else {
            val[j - 1][1]++;
        }
        parent[x] = y;
    }

}

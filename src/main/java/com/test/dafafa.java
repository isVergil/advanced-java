package com.test;

import java.util.*;

/**
 * @ClassName dafafa
 * @Description TODO
 * @Author bill
 * @Date 2022/9/20 19:35
 * @Version 1.0
 **/
public class dafafa {

    public static void main(String[] args) {

    }

    int[] fa = new int[4010];

    int find(int x) {

        // if (x == fa[x]) {
        //     return x;
        // } else {
        //     fa[x] = find(fa[x]);
        //     return fa[x];
        // }
        return x == fa[x] ? x : (fa[x] = find(fa[x]));
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        for (int i = 0; i <= n*2; i++)fa[i] = i;
        for (int[] dislike : dislikes) {
            int a = find(dislike[0]);
            int b = find(dislike[1]);
            if (a == b) {
                return false;
            }
            fa[find(a + n)] = b;
            fa[find(b + n)] = a;
        }
        return true;
    }
}

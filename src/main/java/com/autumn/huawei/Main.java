package com.autumn.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Main
 * @Description TODO
 * @Author bill
 * @Date 2022/9/7 19:02
 * @Version 1.0
 *
 *         3
 *         1
 *         0 1 2
 *         0 1
 **/
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        init(N);
        dis = new int[N];
        for (int i = 0; i < M; i++) {
            String[] str = br.readLine().split("\\s+");
            int father = Integer.parseInt(str[0]);
            for (int j = 1; j < str.length; j++) {
                union(father, Integer.parseInt(str[j]));
                parent2[Integer.parseInt(str[j])] = father;
                dis[Integer.parseInt(str[j])] = 1;
            }
        }
        String[] str1 = br.readLine().split("\\s+");
        int m1 = Integer.parseInt(str1[0]);
        int m2 = Integer.parseInt(str1[1]);
        if (parent1[m1] != parent1[m2]) {
            System.out.println(-1);
        } else {
            int father1 = find2(m1);
            int father2 = find2(m2);
            System.out.println(Math.abs(dis[father1] - dis[father2]));
        }

    }

    static int[] parent1;

    static int[] parent2;

    static int[] dis;

    //初始化
    static void init(int size) {
        parent1 = new int[size];
        for (int i = 0; i < size; i++) {
            parent1[i] = i;
        }
        parent2 = new int[size];
        for (int i = 0; i < size; i++) {
            parent2[i] = i;
        }
    }

    //查询 x 的 根节点
    static int find2(int x) {
        if (parent2[x] != x) {
            int t = parent2[x];
            parent2[x] = find2(parent2[x]);
            dis[x] += dis[t];
        }
        return x;
        //return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    static int find1(int x) {
        return parent1[x] == x ? x : (parent1[x] = find1(parent1[x]));
    }


    //合并,把 j 合并到 i 中去，就是把 j 的根结点设为 i 的根节点
    static void union(int i, int j) {
        parent1[find1(j)] = find1(i);
    }
}

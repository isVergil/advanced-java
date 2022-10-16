package com.autumn.meituan;

import java.util.Scanner;

/**
 * @ClassName Main3
 * @Description TODO
 * @Author bill
 * @Date 2022/9/3 10:37
 * @Version 1.0
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fathers = new int[n];
        int[] sons = new int[n];
        for (int i = 0; i < n - 1; i++) {
            //父节点
            fathers[i] = sc.nextInt();
            //子节点
            sons[i] = i + 2;
        }
        colors = sc.next();
        nodeColors = new String[n + 1];
        for (int i = 0; i < n - 1; i++) {
            union(fathers[i], sons[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (nodeColors[i] == null) {
                System.out.println(0);
            } else {
                System.out.println(nodeColors[i].length());
            }
        }


    }

    static String colors;
    static String[] nodeColors;

    //合并,把 j 合并到 i 中去，就是把 j 的根结点设为 i 的根节点
    static void union(int i, int j) {
        int father = i;
        String color = "" + colors.charAt(i - 1);
        if (nodeColors[father] == null) {
            nodeColors[father] += color;
        } else {
            if (!nodeColors[father].contains(color)) {
                nodeColors[father] += color;
            }
        }
        String colorSon = "" + colors.charAt(j - 1);
        if (nodeColors[father] == null) {
            nodeColors[father] += colorSon;
        } else {
            if (!nodeColors[father].contains(colorSon)) {
                nodeColors[father] += colorSon;
            }
        }
    }
}

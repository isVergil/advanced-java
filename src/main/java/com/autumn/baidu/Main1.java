package com.autumn.baidu;

import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description TODO
 * @Author bill
 * @Date 2022/10/11 20:25
 * @Version 1.0
 **/
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] as = new int[n];
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();
        }
        init(n, as);
        //合并
        for (int i = 1; i < n; i++) {
            union(sc.nextInt(), sc.nextInt());
        }
        //操作数
        int opN = sc.nextInt();
        for (int i = 0; i < opN; i++) {
            operate(sc.nextInt(), sc.nextInt());
        }
        //统计 0 的个数
        for (int i = 1; i <= n; i++) {
            System.out.print(sum0(parent[i][1]) + " ");
        }
    }

    //统计末尾 0 的个数
    static int sum0(int num) {
        int res = 0, m = 0;
        while (num != 0) {
            m = num % 10;
            if (m == 0) {
                res++;
            } else {
                break;
            }
            num /= 10;
        }
        return res;
    }

    //x 的 子树 * y
    static void operate(int x, int y) {
        for (int i = 1; i < parent.length; i++) {
            if (parent[i][0] == x) {
                continue;
            }
            //当前节点 根 为 x 乘积
            if (find(parent[i][0]) == x) {
                parent[i][1] *= y;
            }
        }
    }

    static int[][] parent;

    //初始化
    static void init(int size, int[] as) {
        parent = new int[size + 1][2];
        for (int i = 1; i <= size; i++) {
            parent[i][0] = i;
            parent[i][1] = as[i - 1];
        }
    }

    //查询 x 的 根节点
    static int find(int x) {
        return parent[x][0] == x ? x : (parent[x][0] = find(parent[x][0]));
    }

    //合并,把 j 合并到 i 中去，就是把 j 的根结点设为 i 的根节点
    static void union(int i, int j) {
        parent[find(j)][0] = find(i);
    }

}

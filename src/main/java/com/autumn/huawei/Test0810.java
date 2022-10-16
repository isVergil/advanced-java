package com.autumn.huawei;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @ClassName Test0810
 * @Description TODO
 * @Author bill
 * @Date 2022/8/18 16:42
 * @Version 1.0
 **/
public class Test0810 {

    // 1 内存管理
    // 连续的 1 表示内存段
   /*
    1
    0 1024
    2
    -10 2000
    */

    /*
     2
     0 9
     100 900
     3
     10 120  -2000

 2
 0 12
 100 900
     */
    static int[] memory = new int[5000];

    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int max = 0;
    //     for (int i = 0; i < n; i++) {
    //         int start = sc.nextInt();
    //         int end = sc.nextInt();
    //         for (int j = start; j <= end; j++) {
    //             memory[j] = 1;
    //         }
    //         max = Math.max(max, end);
    //     }
    //     int m = sc.nextInt();
    //     for (int i = 0; i < m; i++) {
    //         int op = sc.nextInt();
    //         cal(op);
    //     }
    //     int res = 0;
    //     int l = 0, r = 0;
    //     List<int[]> indexArr = new ArrayList<>();
    //     while (r <= max) {
    //         if (memory[l] == 1) {
    //             r = l;
    //             res++;
    //             while (r <= max && memory[r] == 1) {
    //                 r++;
    //             }
    //             indexArr.add(new int[]{l, r});
    //             l = r;
    //         } else {
    //             l++;
    //             r++;
    //         }
    //     }
    //     System.out.println(res);
    //     for (int[] ints : indexArr) {
    //         System.out.println(ints[0] + " " + ints[1]);
    //     }
    //
    // }

    static void cal(int op) {
        //添加内存  变 1
        if (op > 0) {
            int l = Math.max(0, op - 2);
            for (int i = 0; i < 4; i++) {
                memory[l + i] = 1;
            }
        } else {   //剔除内存  变 0
            op = -op;
            int l = Math.max(0, op - 2);
            for (int i = 0; i < 4; i++) {
                memory[l + i] = 0;
            }
        }

    }

    //2 西游记取经路线
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int m = sc.nextInt();
    //     int n = sc.nextInt();
    //     int t = sc.nextInt();
    //     int[][] heigh = new int[m][n];
    //     boolean[][] visited = new boolean[m][n];
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             heigh[i][j] = sc.nextInt();
    //         }
    //     }
    //     dfs(0, 0, t, 0, visited, heigh);
    //     System.out.println(step == Integer.MAX_VALUE ? -1 : step);
    //
    // }

    static int chance = 0;

    static int step = Integer.MAX_VALUE;

    static void dfs(int i, int j, int t, int curStep, boolean[][] visited, int[][] heigh) {
        if (visited[i][j] || chance > 3 || i < 0 || i >= heigh.length || j < 0 || j >= heigh[0].length) {
            return;
        }
        if (i == heigh.length - 1 && j == heigh[0].length - 1) {
            step = Math.min(step, curStep);
            return;
        }
        //上
        if (i > 0) {
            if (Math.abs(heigh[i - 1][j] - heigh[i][j]) > t) {
                chance++;
                visited[i][j] = true;
                dfs(i - 1, j, t, curStep + 1, visited, heigh);
                visited[i][j] = false;
                chance--;
            } else {
                visited[i][j] = true;
                dfs(i - 1, j, t, curStep + 1, visited, heigh);
                visited[i][j] = false;
            }
        }
        //下
        if (i <= heigh.length - 2) {
            if (Math.abs(heigh[i + 1][j] - heigh[i][j]) > t) {
                chance++;
                visited[i][j] = true;
                dfs(i + 1, j, t, curStep + 1, visited, heigh);
                visited[i][j] = false;
                chance--;
            } else {
                visited[i][j] = true;
                dfs(i + 1, j, t, curStep + 1, visited, heigh);
                visited[i][j] = false;
            }
        }
        //左
        if (j > 0) {
            if (Math.abs(heigh[i][j] - heigh[i][j - 1]) > t) {
                chance++;
                visited[i][j] = true;
                dfs(i, j - 1, t, curStep + 1, visited, heigh);
                visited[i][j] = false;
                chance--;
            } else {
                visited[i][j] = true;
                dfs(i, j - 1, t, curStep + 1, visited, heigh);
                visited[i][j] = false;
            }
        }
        //右
        if (j <= heigh[0].length - 2) {
            if (Math.abs(heigh[i][j] - heigh[i][j + 1]) > t) {
                chance++;
                visited[i][j] = true;
                dfs(i, j + 1, t, curStep + 1, visited, heigh);
                visited[i][j] = false;
                chance--;
            } else {
                visited[i][j] = true;
                dfs(i, j + 1, t, curStep + 1, visited, heigh);
                visited[i][j] = false;
            }
        }
    }

    /*
    4
    1 1 1 1
    1 1 1 1
    2

    5
    1 1 1 1 1 
    1 1 1 1 1 
    2

    4
    2 1 2 3
    1 2 4 3
    3

     */
    //3 最佳返程方案
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int[][] dis = new int[2][n];
        // for (int i = 0; i < 2; i++) {
        //     for (int j = 0; j < n; j++) {
        //         dis[i][j] = sc.nextInt();
        //     }
        // }
        // int max = sc.nextInt();

        int max = 2;
        int n = 4;
        int[][] dis = new int[2][n];
        dis[0] = new int[]{1, 1, 1, 1};
        dis[1] = new int[]{1, 1, 1, 1};

        //[0, 1, 3, 7, 10]
        prevSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prevSum[i] = prevSum[i - 1] + dis[1][i - 1];
        }
        path.add(0);
        dfs(0, dis[0][0], max, dis);
        System.out.println(spends);
        System.out.println(res);
        int min = Integer.MAX_VALUE;
        for (Integer spend : spends) {
            min = Math.min(spend, min);
        }
        List<List<Integer>> tmp = new ArrayList<>();
        for (int i = 0; i < spends.size(); i++) {
            if (min == spends.get(i)) {
                tmp.add(res.get(i));
            }
        }
        Collections.sort(tmp, (a, b) -> a.get(0) - b.get(0));
        System.out.println(tmp.get(0));

    }

    static int[] prevSum;

    static List<List<Integer>> res = new ArrayList<>();

    static List<Integer> path = new ArrayList<>();

    static List<Integer> spends = new ArrayList<>();

    static void dfs(int cur, int spend, int max, int[][] dis) {
        //cur 到达最后 或者 不能跨过 cur
        if (cur > dis[0].length - 1 || dis[1][cur] > max) {
            return;
        }
        //cur 能到达最后
        if (max >= prevSum[dis[0].length] - prevSum[cur]) {
            spends.add(spend);
            res.add(new ArrayList(path));
            return;
        }
        //cur 能到达的最远距离
        int maxDis = cur + max;
        for (int i = cur + 1; i <= maxDis; i++) {
            path.add(i);
            dfs(i, spend + dis[0][cur], max, dis);
            path.remove(path.size() - 1);

        }
    }

}

package com.autumn.tencent;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description TODO
 * @Author bill
 * @Date 2022/10/16 20:24
 * @Version 1.0
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o2[0] - o1[0];
                }
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            //计算该数的 cnt
            int cnt = cal1(num);
            queue.add(new int[]{num, cnt});
        }
        while (k-- > 0) {
            int[] min = queue.poll();
            int[] newMin = new int[2];
            newMin[0] = min[1];
            newMin[1] = cal1(min[1]);
            queue.offer(newMin);
        }
        //最后统计
        long res = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            res += cur[0];
        }
        System.out.println(res);

    }

    static int cal1(int num) {
        int res = 0;
        while (num != 0) {
            res += (num & 1);
            num >>>= 1;
        }
        return res;
    }
}

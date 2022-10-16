package com.autumn.netease;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description TODO
 * @Author bill
 * @Date 2022/9/4 16:24
 * @Version 1.0
 **/
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int n = sc.nextInt();
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i] = sc.nextInt();
        }
        int[] left2Right = new int[w];
        int[] right2Left = new int[w];
        Arrays.fill(left2Right, -1);
        Arrays.fill(right2Left, -1);
        //从左向右涂
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int curLen = colors[i];
            for (int j = idx; j < curLen + idx; j++) {
                left2Right[j] = i;
            }
            idx = curLen + idx + 1;
        }
        //从右向左
        idx = w - 1;
        for (int i = n - 1; i >= 0; i--) {
            int curLen = colors[i];
            for (int j = idx; j > idx - curLen; j--) {
                right2Left[j] = i;
            }
            idx = idx - curLen - 1;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            if (left2Right[i] == right2Left[i] && left2Right[i] != -1) {
                res.add(i + 1);
            }
        }
        System.out.println(res.size());
        for (Integer re : res) {
            System.out.print(re + " ");
        }

    }

}

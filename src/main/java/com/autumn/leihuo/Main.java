package com.autumn.leihuo;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description TODO
 * @Author bill
 * @Date 2022/9/18 19:04
 * @Version 1.0
 **/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        double sum = 0;
        for (int i = 0; i < M; i++) {
            String cur = sc.next().trim();
            String tmp = sc.next().trim();
            //正确
            if (tmp.equals(cur)) {
                sum += 10;
            } else {
                int score = 0;
                //1 底牌颜色识别正确 +2
                if (cur.charAt(0) == tmp.charAt(0)) {
                    score += 2;
                }
                //2 区域信息识别正确 +3
                String cur1 = cur.substring(1, cur.length() - 5);
                String tmp2 = tmp.substring(1, tmp.length() - 5);
                if (cur1.equals(tmp2)) {
                    score += 3;
                }
                //3 正确车牌的连续长度
                cur1 = cur.substring(cur.length() - 5);
                tmp2 = tmp.substring(tmp.length() - 5);
                if (cur1.equals(tmp2)) {
                    score += 5;
                } else {
                    int max = 0;
                    for (int j = 0; j < 5; j++) {
                        for (int k = j + 1; k <= 5; k++) {
                            String cur2 = cur1.substring(j, k);
                            if (tmp2.contains(cur2)) {
                                max = Math.max(k - j, max);
                            }
                        }
                    }
                    score += max;
                }
                sum += score;
            }
        }
        System.out.println(String.format("%.2f", sum / M * 10) + "%");
    }
}

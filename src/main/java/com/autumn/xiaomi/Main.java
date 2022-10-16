package com.autumn.xiaomi;

import java.util.*;

/**
 * @ClassName Main
 * @Description TODO
 * @Author bill
 * @Date 2022/9/20 19:21
 * @Version 1.0
 **/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        // while (sc.hasNext()) {
        //     list.add(sc.nextInt());
        //     list.add(sc.nextInt());
        // }
        String s = null;
        while (!(s = sc.nextLine()).equals("")) {
            String[] cur = s.split("\\s+");
            list.add(Integer.valueOf(cur[0]));
            list.add(Integer.valueOf(cur[1]));
        }
        int idx = 0;
        int[][] times = new int[list.size() / 2][2];
        for (int i = 0; i < list.size() / 2; i++) {
            for (int j = 0; j < 2; j++) {
                times[i][j] = list.get(idx++);
            }
        }
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        idx = times[0][1];
        int res = times[0][1] - times[0][0];
        for (int i = 1; i < list.size() / 2; i++) {
            if (idx <= times[i][0]) {
                res += times[i][1] - times[i][0];
            } else {
                res += times[i][1] - times[i - 1][1];
            }
            idx = times[i][1];
        }
        System.out.println(res);
    }

}

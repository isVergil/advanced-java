package com.autumn.ms;


import java.util.*;

/**
 * @ClassName Main
 * @Description TODO
 * @Author bill
 * @Date 2022/8/26 20:46
 * @Version 1.0
 **/
public class Main {
    public int solution(int[] A, int M) {
        Map<Long, List<Long>> map = new HashMap<>();
        for (long i : A) {
            if (i >= 0) {
                long yu = i % M;
                List<Long> cur = new ArrayList<>();
                if (map.containsKey(yu)) {
                    cur = map.get(yu);
                }
                cur.add(i);
                map.put(yu, cur);
            } else {
                long yu = (M - i) % M;
                List<Long> cur = new ArrayList<>();
                if (map.containsKey(yu)) {
                    cur = map.get(yu);
                }
                cur.add(i);
                map.put(yu, cur);
            }
        }
        long res = 0;
        for (long i : map.keySet()) {
            if (map.get(i).size() == 1) {
                if (map.get(i).get(0) >= M) {
                    if (map.get(i).get(0) % M == 0) {
                        res = Math.max(res, 1);
                    }
                }
            } else {
                long cur1 = map.get(i).get(0);
                long cur2 = map.get(i).get(1);
                long cur = Math.abs(cur1 - cur2);
                if (cur >= M) {
                    if (cur % M == 0) {
                        res = Math.max(res, map.get(i).size());
                    }
                }
            }
        }
        return (int) res;
    }

    public int solution(int[] A, int[] B) {
        int N = A.length;
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == B[i]) {
                set.add(A[i]);
            }
            max = Math.max(A[i], B[i]);
        }
        for (int i = 1; i < max; i++) {
            if (set.contains(i)) {
                continue;
            }
            return i;
        }
        return max + 1;
    }

}

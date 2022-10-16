package com.autumn.yuanfudao;

import java.util.*;

/**
 * @ClassName Main2
 * @Description TODO
 * @Author bill
 * @Date 2022/8/26 19:49
 * @Version 1.0
 **/
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        while (M-- > 0) {
            int K = sc.nextInt();
            int N = sc.nextInt();
            long[] nums = new long[N];
            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextLong();
            }
            System.out.println(solve(K, nums));

        }
    }

    static int solve(long k, long[] nums) {
        List<Long> set = calK(k);
        int l = 0;
        int res = (int) 1e6;
        while (l < nums.length) {
            List<Long> cur = set;
            if (cur.contains(nums[l])) {
                for (int i = l; i < nums.length; i++) {
                    if (cur.contains(nums[i])) {
                        for (int j = 0; j < cur.size(); j++) {
                            if (nums[i] == cur.get(j)) {
                                cur.remove(j);
                                break;
                            }
                        }
                    }
                    if (cur.size() == 0) {
                        if (i == l) {
                            res = Math.min(1, res);
                        } else {
                            res = Math.min(i - l, res);
                        }
                        break;
                    }
                }
            } else {
                l++;
            }
        }
        return res == (int) 1e6 ? 0 : res;
    }

    static List<Long> calK(long k) {
        List<Long> set = new ArrayList<>();
        long num = k;
        for (long i = 2; i <= num; i++) {
            if (num % i == 0) {
                set.add(i);
                num /= i;
                i--;
            }
        }
        return set;
    }
}

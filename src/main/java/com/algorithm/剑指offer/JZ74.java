package com.algorithm.剑指offer;

import java.util.ArrayList;

/**
 * @ClassName JZ74
 * @Description TODO
 * @Author bill
 * @Date 2021/12/2 14:20
 * @Version 1.0
 **/
/*
和为S的连续正数序列
 */
public class JZ74 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        int l = 1, r = 2, target = 3;
        while (l < r) {
            if (target == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = l; i <= r; i++) {
                    list.add(i);
                }
                res.add(list);
            }
            if (target >= sum) {
                target -= l;
                l++;
            } else {
                r++;
                target += r;
            }
        }
        return res;
    }
}

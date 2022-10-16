package com.test;

import lombok.val;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Test2
 * @Description TODO
 * @Author bill
 * @Date 2021/7/22 21:00
 * @Version 1.0
 **/
public class Test2 {

    public static void main(String[] args) {
        //        Test2 objectA = new Test2();
        //        Test2 objectB = new Test2();
        //        objectA.instance = objectB;
        //        objectB.instance = objectA;
        //        char[] temp = new char[128];
        //        System.out.println(temp[0]);

        int[] group = {9, 9, 6, 0, 6, 6, 9};
        longestWPI(group);
    }

    public static int longestWPI(int[] hours) {
        int n = hours.length;
        int res = 0, cur = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < n; i++) {
            if (hours[i] > 8) {
                cur++;
            } else {
                cur--;
            }
            if (!map.containsKey(cur)) {
                map.put(cur, i);
            }
            if (cur > 0) {
                res = i + 1;
            } else if (map.containsKey(cur - 1)) {
                res = Math.max(res, i - map.get(cur - 1));
            }
        }
        return res;
    }


}


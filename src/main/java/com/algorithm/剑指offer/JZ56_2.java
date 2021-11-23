package com.algorithm.剑指offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName JZ56_2
 * @Description TODO
 * @Author bill
 * @Date 2021/10/26 15:30
 * @Version 1.0
 **/
public class JZ56_2 {
    //法1
    public int singleNumber1(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                counts[i] += num & 1;
                //算数右移   高位补0  左移没有 <<< 运算符  >> 也行
                num >>>= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % 3;
        }
        return res;
    }

    //法2  哈希表存储
    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        //键值对对象集合
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : set) {
            if (integerIntegerEntry.getValue() == 1) {
                return integerIntegerEntry.getKey();
            }
        }
        return -1;
    }

    //法3  有限状态自动机 不会
}

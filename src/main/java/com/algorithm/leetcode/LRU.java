package com.algorithm.leetcode;

import java.util.LinkedHashMap;

/**
 * @ClassName LRU
 * @Description TODO
 * @Author bill
 * @Date 2021/8/16 13:52
 * @Version 1.0
 **/
public class LRU {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(4, 0.75f, true);
        map.put(1, 1);
        map.put(2, 1);
        map.put(3, 1);
        map.put(4, 1);
        map.put(5, 1);
        System.out.println(map);
    }
}

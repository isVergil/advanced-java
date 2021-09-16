package com.internship.bytedance;

import java.util.*;

/**
 * @ClassName LC_451
 * @Description TODO
 * @Author bill
 * @Date 2021/9/16 16:07
 * @Version 1.0
 **/
public class LC_451 {

    //法1
    //遍历用 map 记录字母出现次数
    //对 map 的 value 排序
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        //降序 重写 Comparator 接口
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            int num = map.get(c);
            while (num > 0) {
                sb.append(c);
                num--;
            }
        }
        return sb.toString();
    }
}

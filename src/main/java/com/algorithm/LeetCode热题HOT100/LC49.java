package com.algorithm.LeetCode热题HOT100;

import java.util.*;

/**
 * @ClassName LC49
 * @Description 49. 字母异位词分组
 * @Author bill
 * @Date 2022/3/23 15:59
 * @Version 1.0
 **/
public class LC49 {

    //1、排序+哈希
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String str_ = String.valueOf(strArr);
            if (map.containsKey(str_)) {
                map.get(str_).add(str);
            } else {
                map.put(str_, new ArrayList() {{
                    add(str);
                }});
            }
        }
        return new ArrayList<List<String>>(map.values());
    }


    //2、计数+哈希
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

package com.javabasic._day09_方法引用Stream流File类递归字节流.stream流;

/**
 * @ClassName StreamDemo2
 * @Description TODO
 * @Author bill
 * @Date 2021/7/11 20:41
 * @Version 1.0
 **/

import java.util.*;
import java.util.stream.Stream;

/***
 *   ---Stream流式思想的核心：
 *                  是先得到集合或者数组的Stream流（就是一根传送带）
 *                  然后就用这个Stream流操作集合或者数组的元素。
 *                  然后用Stream流简化替代集合操作的API.
 *
 *       集合获取流的API:
 *           (1) default Stream<E> stream();
 *
 *       小结：
 *            集合获取Stream流用: stream();
 *            数组：Arrays.stream(数组)   /  Stream.of(数组);
 */
public class StreamDemo2 {
    public static void main(String[] args) {
        //Collection 集合获取流
        Collection<String> c1 = new ArrayList<>();
        Stream<String> ss = c1.stream();

        //Map 集合获取流
        Map<String, Integer> map = new HashMap<>();
        //获取键值的stream流
        Stream<String> keys = map.keySet().stream();
        Stream<Integer> values = map.values().stream();
        Stream<Map.Entry<String, Integer>> keyAndValues = map.entrySet().stream();

        //数组 获取流
        String[] arrs = {"dffsf", "fsgsg", "fsg", "grt45"};
        Stream<String> arrs1 = Arrays.stream(arrs);
        Stream<String> arrs2 = Stream.of(arrs);
    }
}

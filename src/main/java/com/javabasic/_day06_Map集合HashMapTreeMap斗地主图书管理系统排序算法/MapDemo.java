package com.javabasic._day06_Map集合HashMapTreeMap斗地主图书管理系统排序算法;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName MapDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/6 19:57
 * @Version 1.0
 * 目标：Map集合概述。
 * Map集合是另一个集合体系。
 * Collection是单值集合体系。
 * Map集合是一种双列集合，每个元素包含两个值。
 * Map集合的每个元素的格式：key=value(键值对元素)。
 * Map集合也被称为“键值对集合”。
 * Map集合的完整格式：{key1=value1 , key2=value2 , key3=value3 , ...}
 * Map集合有啥用？
 * 1.Map集合存储的信息更加的具体丰富。
 * ----Collection: ["苍老师","日本","女","动作演员",23,"广州"]
 * ----Map : {name="苍老师" , jiaxiang=小日本 , sex="女" , age = 23 , addr=广州}
 * 2.Map集合很适合做购物车这样的系统。
 * ----Map:  {娃娃=30 , huawei=1 , iphonex=1}
 * ----
 * 注意：集合和泛型都只能支持引用数据类型，集合完全可以称为是对象容器，存储都是对象。
 * ---
 * Map集合的体系：
 * -----------Map<K , V>(接口,Map集合的祖宗类)
 * ------------/                      \
 * ---TreeMap<K , V>           HashMap<K , V>(实现类,经典的，用的最多)
 * -------------------------------------\
 * --------------------------------LinkedHashMap<K, V>(实现类)
 * ---
 * Map集合的特点：
 * ---1.Map集合的特点都是由键决定的。
 * ---2.Map集合的键是无序,不重复的，无索引的。
 * -------Map集合后面重复的键对应的元素会覆盖前面的整个元素！
 * ---3.Map集合的值无要求。
 * ---4.Map集合的键值对都可以为null。
 * ---
 * HashMap:元素按照键是无序，不重复，无索引，值不做要求。
 * LinkedHashMap:元素按照键是有序，不重复，无索引，值不做要求。
 * ---------
 * ---------
 * Map集合的常用API(重点中的重点)
 * - public V put(K key, V value):  把指定的键与指定的值添加到Map集合中。
 * - public V remove(Object key): 把指定的键 所对应的键值对元素 在Map集合中删除，返回被删除元素的值。
 * - public V get(Object key) 根据指定的键，在Map集合中获取对应的值。
 * - public Set<K> keySet(): 获取Map集合中所有的键，存储到Set集合中。
 * - public Set<Map.Entry<K,V>> entrySet(): 获取到Map集合中所有的键值对对象的集合(Set集合)。
 * - public boolean containKey(Object key):判断该集合中是否有此键。
 * ------
 * ------
 * Map集合的遍历方式有：3种。
 * （1）“键找值”的方式遍历：先获取Map集合全部的键，再根据遍历键找值。
 * （2）“键值对”的方式遍历：难度较大。
 * （3）JDK 1.8开始之后的新技术：Lambda表达式。（暂时了解）
 * -----
 * a.“键找值”的方式遍历Map集合。
 * ---1.先获取Map集合的全部键的Set集合。
 * ---2.遍历键的Set集合，然后通过键找值。
 * ----
 * b.“键值对”的方式遍历。
 * ---1.把Map集合转换成一个Set集合:Set<Map.Entry<K, V>> entrySet();
 * ---2.此时键值对元素的类型就确定了，类型是键值对实体类型：Map.Entry<K, V>
 * ---3.接下来就可以用foreach遍历这个Set集合，类型用Map.Entry<K, V>
 * ---
 * 小结：
 * 代码简单，需要记住!
 **/
public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> maps = new HashMap<>();
        maps.put("1", "1");
        maps.put("2", "2");
        maps.put(null, null);
        Map<String, String> maps1 = new HashMap<>();
        maps.put("3", "3");
        maps.put("4", "4");
        maps.put(null, null);
        maps.putAll(maps1);
        System.out.println(maps);
        System.out.println(maps.get("2"));
        //删除键返回值
        System.out.println(maps.remove("2"));
        System.out.println(maps.containsKey("1"));
        System.out.println(maps.containsValue("2"));
        //获取全部的键的集合，Map集合的键是无序不重复的，故返回的是一个 set 集合
        System.out.println(maps.keySet().getClass());
        //获取全部的值的集合，Map集合的值是不做要求的，故返回的是一个 collection 集合
        System.out.println(maps.values().getClass());

        maps.clear();
        System.out.println(maps.isEmpty());

        //遍历 键找值
        Set<String> keys = maps.keySet();
        for (String key : keys) {
            String value = maps.get(key);
            System.out.println("key" + key + "value" + value);
        }

        //遍历 键值对：面向对象的方式 （整体遍历） 将键值对元素作为一个整体类型，类型是Set<Map.Entry<String, String>> 实体类型
        Set<Map.Entry<String, String>> entries = maps.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + value);
        }

        //遍历 lambda
        maps.forEach((k, v) -> System.out.println(k + v));

    }
}

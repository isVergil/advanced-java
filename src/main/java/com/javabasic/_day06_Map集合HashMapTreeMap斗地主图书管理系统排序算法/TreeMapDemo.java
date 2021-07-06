package com.javabasic._day06_Map集合HashMapTreeMap斗地主图书管理系统排序算法;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @ClassName TreeMapDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/6 20:47
 * @Version 1.0
 * <p>
 * TreeMap集合按照键是可排序不重复的键值对集合。(默认升序)
 * TreeMap集合按照键排序的特点与TreeSet是完全一样的。
 * 小结：
 * TreeMap集合和TreeSet集合都是排序不重复集合
 * TreeSet集合的底层是基于TreeMap，只是键没有附属值而已。
 * 所以TreeMap集合指定大小规则有2种方式：
 * a.直接为对象的类实现比较器规则接口Comparable，重写比较方法（拓展方式）
 * b.直接为集合设置比较器Comparator对象,重写比较方法
 **/
public class TreeMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> maps = new TreeMap<>();
        maps.put(1000000, "张三");
        maps.put(1000000, "张三1");
        maps.put(10000, "李四");
        maps.put(10, "王五");
        maps.put(24244, "张麻子");
        //按照键排序
        System.out.println(maps);

        Map<Pig, String> pigs = new TreeMap<>();
        pigs.put(new Pig("🐖佩奇", 99.5, 500.0), "荷兰");
        pigs.put(new Pig("🐖乔治", 99.4, 605.0), "澳大利亚");
        pigs.put(new Pig("🐗野猪", 199.4, 305.0), "山上");
        pigs.put(new Pig("🐗野猪", 199.4, 305.0), "山上2");
        System.out.println(pigs);

        Map<Pig, String> pigs1 = new TreeMap<>(new Comparator<Pig>() {
            @Override
            public int compare(Pig o1, Pig o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
        pigs1.put(new Pig("🐖佩奇", 99.5, 500.0), "荷兰");
        pigs1.put(new Pig("🐖乔治", 99.4, 605.0), "澳大利亚");
        pigs1.put(new Pig("🐗野猪", 199.4, 305.0), "山上");
        pigs1.put(new Pig("🐗野猪", 199.4, 305.0), "山上2");
        System.out.println(pigs);
    }
}

class Pig implements Comparable {
    private String name;
    private double price;
    private double weight;

    public Pig() {
    }

    public Pig(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pig pig = (Pig) o;
        return Double.compare(pig.price, price) == 0 &&
                Double.compare(pig.weight, weight) == 0 &&
                Objects.equals(name, pig.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, weight);
    }

    @Override
    public String toString() {
        return "Pig{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }

    // 比较者： this
    // 被比较者： o
    // 需求：按照价格排序！
    @Override
    public int compareTo(Object o) {
        // 浮点型的大小比较建议使用Java自己的API:
        // public static int compare(double d1, double d2)
        return -Double.compare(this.price, ((Pig) o).price);
    }
}

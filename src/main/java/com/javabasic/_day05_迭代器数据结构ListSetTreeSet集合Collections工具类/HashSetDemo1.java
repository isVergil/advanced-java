package com.javabasic._day05_迭代器数据结构ListSetTreeSet集合Collections工具类;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

/**
 * @ClassName HashSetDemo1
 * @Description TODO
 * @Author bill
 * @Date 2021/7/5 15:20
 * @Version 1.0
 * 目标：Set系列集合元素去重复的流程。
 * ---------
 * 集合和泛型都只能支持引用数据类型。
 * ---------
 * 1.对于有值特性的，Set集合可以直接判断进行去重复。
 * 2.对于引用数据类型的类对象，Set集合是按照如下流程进行是否重复的判断。
 * ---------Set集合会让两两对象，先调用自己的hashCode()方法得到彼此的哈希值（所谓的内存地址）
 * ---------然后比较两个对象的哈希值是否相同，如果不相同则直接认为两个对象不重复。
 * ---------如果哈希值相同，会继续让两个对象进行equals比较内容是否相同，如果相同认为真的重复了
 * ---------如果不相同认为不重复。
 * ---
 * Set集合会先让对象调用hashCode()方法获取两个对象的哈希值比较
 * --------------/                     \
 * -----------false                    true
 * ------------/                          \
 * --------不重复                        继续让两个对象进行equals比较
 * ----------------------------------------/          \
 * --------------------------------------false        true
 * ----------------------------------------/             \
 * -------------------------------------不重复          重复了
 * --------------
 * 需求：只要对象内容一样，就希望集合认为它们重复了。重写hashCode和equals方法。
 * <p>
 * 小结：
 * 如果希望Set集合认为两个对象只要内容一样就重复了，必须重写对象的hashCode和equals方法。
 * ---
 **/
public class HashSetDemo1 {
    public static void main(String[] args) {
        HashSet<Apple> apples = new HashSet<>();
        apples.add(new Apple("红富士", 12));
        apples.add(new Apple("红富士", 12));
        apples.add(new Apple("红富士1", 12));
        System.out.println(apples);
    }
}

class Apple implements Comparable<Apple>, Cloneable {
    private String name;
    private int age;

    public Apple(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apple apple = (Apple) o;
        return age == apple.age &&
                Objects.equals(name, apple.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //重写比较方法
    @Override
    public int compareTo(Apple o) {
        //规则：按照年龄比较
        if (this.age > o.age) {
            return 1;
        }
        if (this.age < o.age) {
            return -1;
        }
        return 0;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

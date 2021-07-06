package com.javabasic._day06_Map集合HashMapTreeMap斗地主图书管理系统排序算法;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName MapDemo1
 * @Description TODO
 * @Author bill
 * @Date 2021/7/6 20:35
 * @Version 1.0
 **/
public class MapDemo1 {
    public static void main(String[] args) {
        Map<Orange, String> maps = new HashMap<>();
        maps.put(new Orange("1", 1.0, "1"), "武汉\n");
        maps.put(new Orange("1", 1.0, "1"), "长沙\n");
        maps.put(new Orange("3", 3.0, "3"), "宜昌\n");
        System.out.println(maps);

    }
}

class Orange {
    private String name;
    private Double weight;
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Orange(String name, Double weight, String remark) {
        this.name = name;
        this.weight = weight;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", remark='" + remark + '\'' +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orange orange = (Orange) o;
        return Objects.equals(name, orange.name) &&
                Objects.equals(weight, orange.weight) &&
                Objects.equals(remark, orange.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, remark);
    }
}

package com.javabasic._day04_常用API正则表达式泛型Collection集合API;

import java.util.ArrayList;

/**
 * @ClassName GenericityDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/3 22:25
 * @Version 1.0
 * 泛型就是一个标签 <数据类型>
 * 泛型可以在编译阶段约束只能操作某种数据类型
 * ---JDK1.7 开始之后，泛型后面的声明可以省略不写
 * ---泛型和集合都只能支持引用数据类型，不支持基本数据类型
 * ---
 * ---好处：在编译阶段约束了操作的数据类型，从而不会出现类型转换异常，体现严谨性和规范性
 * ---
 * ---泛型类
 * ---修饰符 class 类名<泛型变量>{
 * ---
 * ---}
 * ---//泛型变量建议使用 E、T、K、V
 * ---
 * --- * ---泛型方法
 * ---修饰符 <泛型变量> 返回值类型 方法名称(形参列表){
 * ---
 * ---}
 * ---
 * ---泛型方法和泛型类可以做通用技术架构
 **/
public class GenericityDemo {

    public static void main(String[] args) {
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("242");
        arrayList.add("2242");
        arrayList.add("3242");
        System.out.println(arrayList);

        Integer[] nums = {1, 2, 3, 4, 5, 6, 6};
        System.out.println(arrayToString(nums));
    }

    public static <T> String arrayToString(T[] nums) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (nums != null && nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                T ele = nums[i];
                stringBuilder.append(i == nums.length - 1 ? ele : ele + ",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

class MyArrayList<E> {
    private ArrayList list = new ArrayList();

    public void add(E e) {
        list.add(e);
    }

    public void remove(E e) {
        list.remove(e);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

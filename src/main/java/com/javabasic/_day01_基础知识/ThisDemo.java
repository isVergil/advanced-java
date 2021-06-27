package com.javabasic._day01_基础知识;

/**
 * @ClassName ThisDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/6/26 23:42
 * @Version 1.0
 * - this代表了当前对象的引用。
 * - this可以出现在构造器和方法中。
 * - this出现在构造器中代表构造器正在初始化的对象。
 * - this出现在方法中，哪个对象调用方法，this就代表哪个对象。
 * - this可以访问对象的成员变量，区分成员变量是局部的还是对象中的成员变量。
 **/
public class ThisDemo {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.setName("金毛");
        System.out.println(animal.getName());

        Animal animal2 = new Animal("泰迪", 12, '公');
    }

}

class Animal {
    private String name;
    private int age;
    private char sex;

    public Animal() {

    }

    public Animal(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
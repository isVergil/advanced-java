package com.javabasic._day12_JUnit单元测试反射注解动态代理.反射;

/**
 * @ClassName Student
 * @Description TODO
 * @Author bill
 * @Date 2021/7/17 14:40
 * @Version 1.0
 **/
public class Student {
    private String name;
    private int age;
    public static String school;
    public static final String SCHOOL = "湖南大学";

    public Student(String name, int age) {
        System.out.println("有参构造器");
        this.name = name;
        this.age = age;
    }

    private Student() {
        System.out.println("private的无参构造器");
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
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void publicMethod() {
        System.out.println("publicMethod");
    }

    private void privateMethod() {
        System.out.println("privateMethod");
    }

    private void privateMethodArgs(String name) {
        System.out.println("privateMethodArgs" + name);
    }

    public static void publicstaticMethod() {
        System.out.println("publicstaticMethod");
    }

}

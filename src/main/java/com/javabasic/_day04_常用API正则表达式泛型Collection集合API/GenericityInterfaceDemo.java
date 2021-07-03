package com.javabasic._day04_常用API正则表达式泛型Collection集合API;

import java.util.Date;

/**
 * @ClassName GenericityInterfaceDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/3 22:54
 * @Version 1.0
 * ---JDK1.7 开始之后，泛型后面的声明可以省略不写
 * ---泛型和集合都只能支持引用数据类型，不支持基本数据类型
 * ---
 * ---泛型接口
 * ---修饰符 interface 接口名称<泛型变量>{
 * ---
 * ---}
 * ---//泛型变量建议使用 E、T、K、V
 * ---
 * ---教务系统，提供一个接口可以约束一定要完成数据（学生、老师）的增删改查操作
 **/
public class GenericityInterfaceDemo {
    public static void main(String[] args) {
        Data data = new StudentData();
        data.add(new Student());
    }
}

class StudentData implements Data<Student> {

    @Override
    public void add(Student student) {

    }

    @Override
    public void delete(Student student) {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public Student query(int id) {
        return null;
    }
}

//泛型接口
interface Data<E> {
    void add(E student);

    void delete(E student);

    void update(E student);

    E query(int id);
}

class Student {

}

class Teacher {

}



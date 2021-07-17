package com.javabasic._day12_JUnit单元测试反射注解动态代理.反射;

/**
 * @ClassName ReflectFieldDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/17 15:15
 * @Version 1.0
 **/

import org.junit.Test;

import java.lang.reflect.Field;

/***
 * 目标：反射_获取Field成员变量对象。
 *
 *      反射的第一步是先得到Class类对象。
 *
 *      1、Field getField(String name);
 *             根据成员变量名获得对应Field对象，只能获得public修饰
 *      2.Field getDeclaredField(String name);
 *             根据成员变量名获得对应Field对象，只要申明了就可以得到
 *      3.Field[] getFields();
 *             获得所有的成员变量对应的Field对象，只能获得public的
 *      4.Field[] getDeclaredFields();
 *             获得所有的成员变量对应的Field对象，只要申明了就可以得到
 *      小结：
 *         获取全部成员变量：getDeclaredFields
 *         获取某个成员变量：getDeclaredField
 *
 * ============================================================================================
 * 目标：反射获取成员变量: 取值和赋值。
 *
 *     Field的方法：给成员变量赋值和取值
 *         void set(Object obj, Object value)：给对象注入某个成员变量数据
 *         Object get(Object obj):获取对象的成员变量的值。
 *         void setAccessible(true);暴力反射，设置为可以直接访问私有类型的属性。
 *         Class getType(); 获取属性的类型，返回Class对象。
 *         String getName(); 获取属性的名称。
 */
public class ReflectFieldDemo {
    //1、获取全部的成员变量
    @Test
    public void getDeclaredFields() {
        Class c = Student.class;
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getType() + "---" + field.getName());
        }
    }

    //2、获取某个成员变量
    @Test
    public void getDeclaredField() throws NoSuchFieldException {
        Class c = Student.class;
        //定位某个成员变量对象，根据名称定位
        Field field = c.getDeclaredField("SCHOOL");
        System.out.println(field.getType() + "---" + field.getName());
    }

    //3、给成员变量赋值
    @Test
    public void setField() throws Exception {
        Class c = Student.class;
        //定位某个成员变量对象，根据名称定位
        Field age = c.getDeclaredField("age");
        Student student = new Student("bill", 18);
        //必须先暴力反射 才能破坏封装性
        age.setAccessible(true);
        age.set(student, 20);
        System.out.println(student);

        //获取成员变量的值
        int age_ = (int) age.get(student);
        System.out.println(age_);
    }
}

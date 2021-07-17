package com.javabasic._day12_JUnit单元测试反射注解动态代理.反射;

/**
 * @ClassName ReflectConstructorDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/17 15:04
 * @Version 1.0
 **/

import org.junit.Test;

import java.lang.reflect.Constructor;

/***
 *  目标: 反射_获取Constructor构造器然后通过这个构造器初始化对象。
 *
 *     反射获取Class中的构造器对象Constructor作用：
 *             也是初始化并得到类的一个对象返回。
 *
 *     Constructor的API:
 *          1. T newInstance(Object... initargs)
 *                 创建对象，注入构造器需要的数据。
 *          2. void setAccessible(true)
 *                 修改访问权限，true代表暴力攻破权限，false表示保留不可访问权限(暴力反射)
 *     小结：
 *         可以通过定位类的构造器对象。
 *         如果构造器对象没有访问权限可以通过：void setAccessible(true)打开权限
 *         构造器可以通过T newInstance(Object... initargs)调用自己，传入参数！
 */
public class ReflectConstructorDemo {
    //1、调用无参数构造器得到一个类的对象返回
    @Test
    public void createObj01() throws Exception {
        //反射第一步是得到 class 对象
        Class c = Student.class;
        Constructor constructor = c.getDeclaredConstructor();
        constructor.setAccessible(true);    //暴力打开私有构造器的访问权限 ，一次有效
        //创建对象返回
        Student student = (Student) constructor.newInstance();
        System.out.println(student);
    }

    //2、调用有参数构造器得到一个类的对象返回
    @Test
    public void createObj02() throws Exception {
        //反射第一步是得到 class 对象
        Class c = Student.class;
        Constructor constructor = c.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);    //暴力打开私有构造器的访问权限 ，一次有效
        //创建对象返回
        Student student = (Student) constructor.newInstance("bill", 18);
        System.out.println(student);
    }
}

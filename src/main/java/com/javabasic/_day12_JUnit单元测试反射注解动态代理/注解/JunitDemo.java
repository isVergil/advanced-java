package com.javabasic._day12_JUnit单元测试反射注解动态代理.注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * @ClassName JunitDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/17 16:35
 * @Version 1.0
 **/

/***
 *  目标：自定义注解模拟写一个Junit框架的基本使用。
 *
 *     需求：定义若干个方法，只要加了MyTest注解，
 *           就可以被自动触发执行。
 *
 *     分析：
 *         （1）定义一个自定义注解MyTest.
 *                 -- 只能注解方法。
 *                 -- 存活范围一直都在。
 *         （2）定义若干个方法，只要有@MyTest注解的方法就能被触发执行！！
 *              没有这个注解的方法不能执行！！
 *     小结：
 *         注解和反射可以配合解决一些框架思想
 *         注解可以实现标记的成分做特殊处理!!
 */
public class JunitDemo {
    @NewTest
    public void test01() {
        System.out.println("===test01===");
    }

    public void test02() {
        System.out.println("===test02===");
    }

    @NewTest
    public void test03() {
        System.out.println("===test03===");
    }

    @NewTest
    public void test04() {
        System.out.println("===test04===");
    }

    public static void main(String[] args) throws Exception {
        JunitDemo t = new JunitDemo();
        // 模拟测试类的启动按钮，实现有注解标记的方法就要触发执行。
        // 1.得到类对象
        Class c = JunitDemo.class;
        // 2.获取类中全部方法对象
        Method[] methods = c.getDeclaredMethods();
        // 3.遍历全部方法，有注解就触发执行
        for (Method method : methods) {
            if (method.isAnnotationPresent(NewTest.class)) {
                // 触发此方法执行。
                method.invoke(t);
            }
        }
    }
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface NewTest {

}

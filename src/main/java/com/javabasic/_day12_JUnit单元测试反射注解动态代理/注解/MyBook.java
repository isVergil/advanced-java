package com.javabasic._day12_JUnit单元测试反射注解动态代理.注解;

/**
 * @ClassName MyBook
 * @Description TODO
 * @Author bill
 * @Date 2021/7/17 16:03
 * @Version 1.0
 **/

import com.javabasic._day12_JUnit单元测试反射注解动态代理.反射.Student;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 * 目标：我们之前都是用别人写好的注解，今天我们自己来做注解。
 *
 *  自定义注解的格式：
 *      修饰符 @interface 注解名{
 *           // 注解属性
 *      }
 *
 *   小结：
 *         自定义注解用@interface关键字。
 *         使用注解的格式：@注解名称。
 *         注解默认可以标记很多地方。
 * =============================================================
 * 目标：注解的属性：
 *
 *      属性的格式
 *             - 格式1：数据类型 属性名();
 *             - 格式2：数据类型 属性名() default 默认值;
 *
 *      属性适用的数据类型:
 *             八种数据数据类型(int，short，long，double，byte
 *              ，char，boolean，float)
 *             String，Class
 *             以上类型的数组形式都支持
 *
 *      小结：
 *         注解可以有属性，属性名必须带()
 *         在用注解的时候，属性必须赋值，除非这个属性有默认值！！
 *
 * =============================================================
 *     目标：注解的特殊属性名称：value
 *         value属性，如果只有一个value属性的情况下，
 *         使用value属性的时候可以省略value名称不写!!
 *
 *         但是如果有多个属性,且多个属性没有默认值，那么value是不能省略的。
 *
 *  ==============================================================
 *  目标：元注解
 *
 *      元注解是sun公司提供的。
 *      元注解是用在自定义注解上的注解。
 *      元注解是用来注解自定义注解的。
 *
 *      元注解有两个：
 *          @Target:约束自定义注解只能在哪些地方使用，
 *              -- 但是默认的注解可以在类，方法，构造器，成员变量，... 使用。
 *
 *          @Retention：申明注解的生命周期
 *              -- 申明注解的作用范围：编译时，运行时。
 *
 *      @Target
 *           * 作用：用来标识注解使用的位置，如果没有使用该注解标识，则自定义的注解可以使用在任意位置。
 *           * 可使用的值定义在ElementType枚举类中，常用值如下
 *              TYPE，类，接口
 *              FIELD, 成员变量
 *              METHOD, 成员方法
 *              PARAMETER, 方法参数
 *              CONSTRUCTOR, 构造器
 *              LOCAL_VARIABLE, 局部变量
 *
 *      @Retention
 *          作用：用来标识注解的生命周期(有效存活范围)
 *           * 可使用的值定义在RetentionPolicy枚举类中，常用值如下
 *           * SOURCE：注解只作用在源码阶段，生成的字节码文件中不存在    一编译就消失
 *           * CLASS：注解作用在源码阶段，字节码文件阶段，运行阶段不存在，默认值.
 *           * RUNTIME：注解作用在源码阶段，字节码文件阶段，运行阶段（开发常用）   永远都活着
 *      小结：
 *         @Target约束自定义注解可以标记的范围。
 *         @Retention用来约束自定义注解的存活范围。
 */

@Book(name = "bill", author = {"1", "2"}, price = 15, value = "fsf")
public class MyBook {
    @Book(name = "bill", author = {"1", "2"}, price = 15, value = "fsf")
    @MyTest("test")
    @My
    public static void main(String[] args) {
        System.out.println();
    }

    @My
    private String fs;
}

@interface Book {
    String value();

    String name();

    String[] author();

    int price();

    String address() default "广州";
}

@interface MyTest {
    String value();

    int tets1() default 15;
}

//声明只能注解方法和成员变量
//声明只能注解方法
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface My {

}

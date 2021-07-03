package com.javabasic._day04_常用API正则表达式泛型Collection集合API;

/**
 * @ClassName PackageClass
 * @Description TODO
 * @Author bill
 * @Date 2021/7/3 21:56
 * @Version 1.0
 * -----
 * Java提供了两个类型系统，基本类型与引用类型，使用基本类型在于效率，然而很多情况，会创建对象使用，因为对象可以做更多的功能，
 * 如果想要我们的基本类型像对象一样操作，就可以使用基本类型对应的包装类，如下：
 * -----
 * | 基本类型  | 对应的包装类（位于java.lang包中）     |
 * | -------- | --------------------------------- |
 * | byte     | Byte                              |
 * | short    | Short                             |
 * | int      | Integer                           |
 * | long     | Long                              |
 * | float    | Float                             |
 * | double   | Double                            |
 * | char     | Character                         |
 * | boolean  | Boolean                           |
 * -
 * -
 * 自动装箱：从基本类型转换为对应的包装类对象。
 * 自动拆箱：从包装类对象转换为对应的基本类型。
 * -
 * -包装类可以为null
 * -
 * -1、基本类型转换为String
 * ----- 方式一：直接在数字后加一个空字符串
 * ----- 方式二：通过String类静态方法valueOf()
 * -2、String转换成基本类型(valueOf、parseInt)
 * ----- 方式一：先将字符串数字转成Integer，再调用valueOf()方法
 * ----- 方式二：通过Integer静态方法parseInt()进行转换
 **/
public class PackageClass {
    public static void main(String[] args) {
        //手动装箱
        Integer integer = Integer.valueOf(12);
        //手动拆箱
        String dsf = "1234";
        System.out.println(Integer.valueOf(dsf));
        System.out.println(Integer.parseInt(dsf));
    }
}

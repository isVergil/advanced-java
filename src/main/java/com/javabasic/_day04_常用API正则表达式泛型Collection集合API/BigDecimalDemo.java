package com.javabasic._day04_常用API正则表达式泛型Collection集合API;

import java.math.BigDecimal;

/**
 * @ClassName BigDecimalDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/3 21:34
 * @Version 1.0
 * Java在java.math包中提供的API类BigDecimal，用来对超过16位有效位的数进行精确的运算。
 * 双精度浮点型变量double可以处理16位有效数，
 * 但在实际应用中，可能需要对更大或者更小的数进行运算和处理。
 * -
 * -处理数据失真
 * -https://blog.csdn.net/xiaoxiaole0313/article/details/107328700/
 **/
public class BigDecimalDemo {
    public static void main(String[] args) {
        double a=0.1;
        double b=0.2;
        System.out.println(0.1 + 0.2);
        BigDecimal bigDecimal1 = BigDecimal.valueOf(a);
        //BigDecimal bigDecimal1 = BigDecimal.valueOf(0.1);
        BigDecimal bigDecimal2 = BigDecimal.valueOf(b);
        //System.out.println(bigDecimal1.add(bigDecimal2));
        System.out.println(BigDecimal.valueOf(b).add(BigDecimal.valueOf(a)));
        System.out.println(BigDecimal.valueOf(b).subtract(BigDecimal.valueOf(a)));
        System.out.println(BigDecimal.valueOf(b).multiply(BigDecimal.valueOf(a)));
        System.out.println(BigDecimal.valueOf(b).divide(BigDecimal.valueOf(a)));
    }
}

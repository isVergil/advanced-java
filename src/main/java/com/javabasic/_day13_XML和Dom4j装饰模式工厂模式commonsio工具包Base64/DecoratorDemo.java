package com.javabasic._day13_XML和Dom4j装饰模式工厂模式commonsio工具包Base64;

/**
 * @ClassName DecoratorDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/18 0:05
 * @Version 1.0
 **/

/***
 *     目标：装饰模式。
 *
 *     装饰模式指的是在不改变原类, 动态地扩展一个类的功能。
 *     思想：是创建一个新类，包装原始类，从而在新类中提升原来类的功能！！
 *     小结：
 *          装饰模式可以在不改变原类的基础上对类中的方法进行扩展增强,实现原则为:
 *          1.定义父类。
 *          2.定义原始类，继承父类，定义功能。
 *          3.定义装饰类，继承父类，包装原始类，增强功能！！
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        InputStream is = new BufferedInputStrem(new FileInputStream());
        is.read();
        is.close();
    }
}

abstract class InputStream {
    public abstract void read();

    public abstract void close();
}

class FileInputStream extends InputStream {
    @Override
    public void read() {
        System.out.println("读取数据~~~");
    }

    @Override
    public void close() {
        System.out.println("关闭流~~~");
    }
}

// 装饰模式！提升原始功能！！！
class BufferedInputStrem extends InputStream {
    private InputStream is;

    public BufferedInputStrem(InputStream is) {
        this.is = is;
    }

    @Override
    public void read() {
        System.out.println("开启高效缓冲读取~");
        is.read();
    }

    @Override
    public void close() {
        is.close();
    }
}


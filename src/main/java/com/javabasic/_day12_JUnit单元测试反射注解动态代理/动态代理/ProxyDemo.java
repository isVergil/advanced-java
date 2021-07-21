package com.javabasic._day12_JUnit单元测试反射注解动态代理.动态代理;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName ProxyDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/21 16:55
 * @Version 1.0
 **/
public class ProxyDemo {
    public static void main(String[] args) {

        //静态代理
        Speaker lawyerStatic = new LawyerStatic();
        lawyerStatic.speak();

        //JDK_动态代理--本体必须实现接口 ZhangSan 实现了 Speaker接口 才能被代理
        LawyerProxy lawyerProxy = new LawyerProxy(new ZhangSan());
        Speaker speakerProxy = (Speaker) Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(), new Class[]{Speaker.class}, lawyerProxy);
        speakerProxy.speak();

        //CGLib_动态代理--是JDK_动态代理的补充，为没有实现接口的类实现动态代理
        LawyerInteceptor lawyerInteceptor = new LawyerInteceptor(new LiSi());
        LiSi liSi = (LiSi) Enhancer.create(LiSi.class, lawyerInteceptor); //类，抽象代理层
        liSi.speak();

    }
}

interface Speaker {
    void speak();
}

class ZhangSan implements Speaker {

    @Override
    public void speak() {
        System.out.println("speak");
    }
}

//静态代理
class LawyerStatic implements Speaker {

    @Override
    public void speak() {
        System.out.println("一些操作1");
        System.out.println("speak");
        System.out.println("一些操作2");
    }
}

//JDK-动态代理
class LawyerProxy implements InvocationHandler {
    //不指定具体的实现类
    private Object object = new Object();

    public LawyerProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("speak")) {
            System.out.println("一些操作1");
            method.invoke(object, args);    //反射
            System.out.println("一些操作2");
        }
        return null;
    }
}

//CGLib-动态代理
class LiSi {
    public void speak() {
        System.out.println("LiSi speak");
    }
}

class LawyerInteceptor implements MethodInterceptor {
    //不指定具体的实现类
    private Object object = new Object();

    public LawyerInteceptor(Object object) {
        this.object = object;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("speak")) {
            System.out.println("一些操作1");
            method.invoke(object, args);    //反射
            System.out.println("一些操作2");
        }
        return null;
    }
}

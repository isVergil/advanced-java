package com.javabasic._day12_JUnit单元测试反射注解动态代理.反射;

/**
 * @ClassName ReflectDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/17 14:36
 * @Version 1.0
 **/

import org.junit.Test;

import java.lang.reflect.Constructor;

/***
 * 目标：反射的概念。
 *
 *     反射，注解，代理，泛型是Java的高级技术，是以后框架的底层原理必须使用到的技术。
 *
 *     反射：是Java独有的技术。是Java技术显著的特点。
 *
 *     反射是指对于任何一个类，在"运行的时候"都可以直接得到这个类全部成分。
 *         在运行时,可以直接得到这个类的构造器对象。（Constructor）
 *         在运行时,可以直接得到这个类的成员变量对象。（Field）
 *         在运行时,可以直接得到这个类的成员方法对象。（Method）
 *
 *     反射的核心思想和关键就是得到：编译以后的class文件对象。
 *
 *     反射提供了一个Class类型，就是可以得到编译以后的class类对象。
 *         HelloWorld.java -> javac -> HelloWorld.class
 *
 *         Class c = HelloWorld.class;
 *
 *
 *     注意：反射是工作在运行时的技术，因为只有运行之后才会有class类对象。
 *
 *     小结：
 *         反射的核心思想和关键就是得到：编译以后的class文件对象。
 *         反射是在运行时获取类的字节码文件对象：然后可以解析类中的全部成分。
 *
 *  ========================================================================================================
 * 目标：反射获取Class类对象。
 *
 *     引入：
 *         反射是通过先得到编译以后的Class类对象：字节码文件。
 *         然后才可以得到类中的全部成分，进行一些功能设计。
 *
 *     反射为一个类的全部成分都设计了一个类型来代表这个对象：
 *         Class : 字节码文件的类型
 *         Constructor : 构造器的类型
 *         Field : 成员变量的类型
 *         Method : 方法的类型
 *
 *     反射技术的第一步永远是先得到Class类对象:有三种方式获取
 *         （1） 类名.class
 *         （2） 通过类的对象.getClass()方法
 *         （3） Class.forName("类的全限名")
 *                 -- public static Class<?> forName(String className)
 *
 *     Class类下的方法：
 *          String getSimpleName(); 获得类名字符串：类名
 *          String getName();  获得类全名：包名+类名
 *          T newInstance() ;  创建Class对象关联类的对象,其实底层也是调用无参数构造器，已经被淘汰。
 *     小结：
 *         Class类对象的获取有三种方式：
 *             1.类名.class。
 *             2.通过类的对象.getClass()方法。
 *             3.Class.forName("类的全限名")。
 *         Class类的方法：
 *             String getSimpleName(); 获得类名字符串：类名
 *             String getName();  获得类全名：包名+类名
 *
 *  ==================================================================================================================
 *  目标：反射_获取Constructor构造器对象.
 *
 *     反射的第一步是先得到Class类对象。（Class文件）
 *
 *     反射中Class类型获取构造器提供了很多的API:
 *          1. Constructor getConstructor(Class... parameterTypes)
 *             根据参数匹配获取某个构造器，只能拿public修饰的构造器，几乎不用！
 *          2. Constructor getDeclaredConstructor(Class... parameterTypes)
 *             根据参数匹配获取某个构造器，只要申明就可以定位，不关心权限修饰符，建议使用！
 *          3. Constructor[] getConstructors()
 *             获取所有的构造器，只能拿public修饰的构造器。几乎不用！！太弱了！
 *          4. Constructor[] getDeclaredConstructors()
 *             获取所有申明的构造器，只要你写我就能拿到，无所谓权限。建议使用！！
 *     小结：
 *         获取类的全部构造器对象： Constructor[] getDeclaredConstructors()
 *             -- 获取所有申明的构造器，只要你写我就能拿到，无所谓权限。建议使用！！
 *         获取类的某个构造器对象：Constructor getDeclaredConstructor(Class... parameterTypes)
 *             -- 根据参数匹配获取某个构造器，只要申明就可以定位，不关心权限修饰符，建议使用！
 */
public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        // 反射的第一步永远是先得到类的Class文件对象: 字节码文件。
        // 1.类名.class
        Class<?> c1 = Student.class;
        System.out.println(c1);

        // 2.对象.getClass()
        Student student = new Student("bill", 18);
        Class c2 = student.getClass();
        System.out.println(c2);

        // 3.Class.forName("类的全限名")  触发类加载器 直接去加载该类的class文件。
        Class c3 = Class.forName("com.javabasic._day12_JUnit单元测试反射注解动态代理.反射.Student");
        System.out.println(c3);

        System.out.println(c1.getSimpleName());           //获取类名本身
        System.out.println(c1.getName());                 //获取类的全限名
        Student student1 = (Student) c1.newInstance();    //调用无参构造器得到对象，被淘汰了

        System.out.println();


    }

    //获取全部的 public 构造器
    @Test
    public void getConstructors() {
        Class c = Student.class;
        Constructor[] constructors = c.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getParameterCount());
        }
    }

    //获取全部的构造器
    @Test
    public void getDeclaredConstructors() throws NoSuchMethodException {
        Class c = Student.class;
        Constructor[] constructors = c.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getParameterCount());
        }
    }

    //获取某个指定的public构造器
    @Test
    public void getConstructor() throws NoSuchMethodException {
        Class c = Student.class;
        Constructor constructor = c.getConstructor(String.class, int.class);
        System.out.println(constructor.getParameterCount());

    }

    // getDeclaredConstructor
    // 获取某个构造器：只要你敢写，这里就能拿到，无所谓权限是否可及。
    @Test
    public void getDeclaredConstructor() throws Exception {
        // a.反射第一步先得到Class类对象
        Class c = Student.class ;
        // b.getDeclaredConstructor()：定位某个构造器，根据参数匹配，只要申明了就可以获取
        Constructor con = c.getDeclaredConstructor(); // 可以拿到！定位无参数构造器！
        //Constructor con = c.getDeclaredConstructor(String.class  , int.class); // 有参数的！!
        // c.构造器名称和参数
        System.out.println(con.getName()+"===>"+con.getParameterCount());
    }
}

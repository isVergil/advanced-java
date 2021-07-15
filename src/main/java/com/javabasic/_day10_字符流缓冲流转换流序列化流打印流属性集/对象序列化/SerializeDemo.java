package com.javabasic._day10_字符流缓冲流转换流序列化流打印流属性集.对象序列化;

/**
 * @ClassName SerializeDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/15 16:23
 * @Version 1.0
 **/

import java.io.*;

/***
 *   目标:对象序列化技术。
 *
 *      对象序列化：就是把Java对象数据直接存储到文件中去。           对象 => 文件中
 *      对象反序列化：就是把Java对象的文件数据恢复到Java对象中。     文件中 => 对象
 *
 *                    字节流                                    字符流
 *      字节输入流               字节输出流              字符输入流          字符输出流
 *      InputStream             OutputStream          Reader             Writer   (抽象类)
 *      FileInputStream         FileOutputStream      FileReader         FileWriter(实现类)
 *      BufferedInputStream     BufferedOutputStream  BufferedReader     BufferedWriter(实现类，缓冲流)
 *                                                    InputStreamReader  OutputStreamWriter
 *      ObjectInputStream       ObjectOutputStream
 *
 *      对象序列化流（对象字节输出流）：ObjectOutputStream
 *          -- 作用：把内存中的Java对象数据保存到文件中去。
 *          -- 构造器：   public ObjectOutputStream(OutputStream out)
 *          -- 序列化方法：public final void writeObject(Object obj)
 *
 *      注意：对象如果想参与序列化，对象必须实现序列化接口 implements Serializable ，否则序列化失败！（序列化规则）
 *
 *     小结：
 *          注意：对象如果想参与序列化，对象必须实现序列化接口 implements Serializable ，否则序列化失败！
 *          对象序列化使用的流是对象字节输出流：ObjectOutputStream
 *
 * ---------------------------------------------------------------------------------------------------------------------------
 *      对象反序列化（对象字节输入流）：ObjectInputStream
 *          -- 作用：读取序列化的对象文件恢复到Java对象中。
 *          -- 构造器：public ObjectInputStream(InputStream is)
 *          -- 方法：public final Object readObject()
 *
 *      如果一个字段不想参数序列化：
 *              transient修饰该成员变量，它将不参与序列化！
 *      序列化版本号：
 *          // 加入序列版本号
 *          private static final long serialVersionUID = 2L;
 *          必须序列化使用的版本号和反序列化使用的版本号一致才可以正常反序列化！否则报错！
 *      小结：
 *         对象反序列化可以把对象序列化的文件数据恢复成Java对象。
 *         对象反序列化使用的流是：ObjectInputStream.
 */
public class SerializeDemo {
    public static void main(String[] args) throws Exception {
        //对象序列化
        // 1.创建User用户对象
        User user = new User("bill", "s1234", "红孩儿");
        // 2.创建低级的字节输出流通向目标文件
        OutputStream os = new FileOutputStream("src\\main\\java\\com\\javabasic\\_day10_字符流缓冲流转换流序列化流打印流属性集\\对象序列化\\obj.dat");
        // 3.把低级的字节输出流包装成高级的对象字节输出流ObjectOutputStream
        ObjectOutputStream oos = new ObjectOutputStream(os);
        // 4.通过对象字节输出流序列化对象：
        oos.writeObject(user);
        // 6.释放资源
        oos.close();
        System.out.println("序列化对象成功~~~~");


        //对象反序列化
        // 1.定义一个低级的字节输入流通向源文件
        InputStream is = new FileInputStream("src\\main\\java\\com\\javabasic\\_day10_字符流缓冲流转换流序列化流打印流属性集\\对象序列化\\obj.dat");
        // 2.把字节输入流包装成高的对象字节输入流
        ObjectInputStream ois = new ObjectInputStream(is);
        // 3.反序列化
        User users = (User) ois.readObject();
        System.out.println(users);
        System.out.println("反序列化完成！");
    }
}

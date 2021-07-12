package com.javabasic._day09_方法引用Stream流File类递归字节流.IO流;

/**
 * @ClassName OutputStreamDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/12 15:04
 * @Version 1.0
 **/

import java.io.*;

/***
 * 目标：字节输出流的使用。
 *
 *     IO流的体系：
 *             字节流                                   字符流
 *     字节输入流           字节输出流               字符输入流       字符输出流
 *     InputStream         OutputStream           Reader         Writer     (抽象类)
 *     FileInputStream     FileOutputStream       FileReader     FileWriter (实现类)
 *
 *     a.FileOutputStream文件字节输出流
 *         -- 作用：以内存为基准，把内存中的数据，按照字节的形式写出到磁盘文件中去。
 *                  简单来说，把内存数据按照字节写出到磁盘文件中去。
 *         -- 构造器：
 *             public FileOutputStream(File file):创建一个字节输出流管道通向目标文件对象。
 *             public FileOutputStream(String file):创建一个字节输出流管道通向目标文件路径。
 *             public FileOutputStream(File file , boolean append):创建一个追加数据的字节输出流管道通向目标文件对象。
 *             public FileOutputStream(String file , boolean append):创建一个追加数据的字节输出流管道通向目标文件路径。
 *         -- 方法：
 *            public void write(int a):写一个字节出去 。
 *            public void write(byte[] buffer):写一个字节数组出去。
 *            public void write(byte[] buffer , int pos , int len):写一个字节数组的一部分出去。
 *                         参数一，字节数组；参数二：起始字节索引位置，参数三：写多少个字节数出去。
 *     小结：
 *         字节输出流只能写字节出去。
 *         字节输出流默认是覆盖数据管道。
 *         换行用： os.write("\r\n".getBytes());
 *         关闭和刷新：刷新流可以继续使用，关闭包含刷新数据但是流就不能使用了！
 *
 *   FileOutputStream字节输出流每次启动写数据的时候都会先清空之前的全部数据，从新写入。
 *     小结：
 *         覆盖数据管道： OutputStream os = new FileOutputStream("Day09Demo/out05");
 *         追加数据的管道：OutputStream os = new FileOutputStream("Day09Demo/out05" , true);
 *                  参数二代表了此管道是追加数据的管道，不会覆盖之前的数据！
 *
 *  -----------------目标：字节流做文件复制。--------------------------------------
 *
 *     字节流复制的思想：
 *         字节是计算机中一切文件的组成，所以
 *         字节流适合做一切文件的复制。
 *         复制是把源文件的全部字节一字不漏的转移到目标文件，只要文件前后的格式一样，绝对不会有问题。
 *
 *     需求：
 *         原文件：D:\itcast\图片资源\meinv.jpg
 *         目标文件：D:\itcast\meimei.jpg
 *     分析步骤：
 *         （1）创建一个字节输入流管道与源文件接通。
 *         （2）创建一个字节输出流与目标文件接通。
 *         （3）创建一个字节数组作为桶
 *         （4）从字节输入流管道中读取数据，写出到字节输出流管道即可。
 *         （5）关闭资源！
 *
 *
 *
 *  -----------------目标：JDK 1.7开始之后释放资源的新方式--------------------
 *     try-with-resources:
 *          try(
 *                 // 这里只能放置资源对象，用完会自动调用close()关闭
 *          ){
 *
 *          }catch(Exception e){
 *               e.printStackTrace();
 *          }
 *     什么是资源？
 *          资源类一定是实现了Closeable接口，实现这个接口的类就是资源
 *          有close()方法，try-with-resources会自动调用它的close()关闭资源。
 */
public class OutputStreamDemo {
    public static void main(String[] args) throws Exception {
        //File file = new File("src\\main\\java\\com\\javabasic\\_day09_方法引用Stream流File类递归字节流\\text2.txt");
        //OutputStream outputStream=new FileOutputStream(file);

        //简化写法
        OutputStream outputStream = new FileOutputStream("src\\main\\java\\com\\javabasic\\_day09_方法引用Stream流File类递归字节流\\text2.txt");
        //写数据
        outputStream.write(97);
        outputStream.write('l');
        outputStream.write('o');
        outputStream.write('v');

        byte[] bytes = {98, 23, 89, 99};
        outputStream.write(bytes);

        byte[] bytes1 = "fsgv常规赛颜色是".getBytes(); //18+4 个字符
        outputStream.write(bytes1);

        outputStream.flush(); //立即刷新数据到文件中去，刷新后管道可以继续用
        outputStream.close(); //关闭资源管道，关闭后不能使用


        //字节流复制
        InputStream is = null;
        OutputStream os = null;
        try {
            /** （1）创建一个字节输入流管道与源文件接通。 */
            is = new FileInputStream("C:\\Users\\bill\\Desktop\\壁纸\\wallhaven-1k1k8w.jpg");
            /** （2）创建一个字节输出流与目标文件接通。*/
            os = new FileOutputStream("C:\\Users\\bill\\Desktop\\wallhaven-1k1k8w.jpg");
            /** （3）创建一个字节数组作为桶*/
            byte[] buffer = new byte[1024];
            /** （4）从字节输入流管道中读取数据，写出到字节输出流管道即可。*/
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                // 读取多少就倒出多少
                os.write(buffer, 0, len);
            }
            System.out.println("复制完成！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /**（5）关闭资源！ */
            try {
                if (os != null) os.close();
                if (is != null) is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        //try-with-resources:
        try (
                /** （1）创建一个字节输入流管道与源文件接通。 */
                InputStream is1 = new FileInputStream("D:\\itcast\\图片资源\\meinv.jpg");
                /** （2）创建一个字节输出流与目标文件接通。*/
                OutputStream os1 = new FileOutputStream("D:\\itcast\\meimei.jpg");
                /** （5）关闭资源！是自动进行的 */
        ) {
            /** （3）创建一个字节数组作为桶*/
            byte[] buffer = new byte[1024];
            /** （4）从字节输入流管道中读取数据，写出到字节输出流管道即可。*/
            int len = 0;
            while ((len = is1.read(buffer)) != -1) {
                // 读取多少就倒出多少
                os1.write(buffer, 0, len);
            }
            System.out.println("复制完成！");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

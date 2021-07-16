package com.javabasic._day11_Socket网络编程NIO;

/**
 * @ClassName CopyDirDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/16 13:38
 * @Version 1.0
 **/

import java.io.*;


/***
 * 目标：复制文件夹。（面试题，拓展）
 *
 *     源文件：       D:\学习资料\java进阶13天资料\copyTest\1
 *     目标文件：     D:\学习资料\java进阶13天资料\copyTest\2
 */
public class CopyDirDemo {
    public static void main(String[] args) throws Exception {
        copyDir(new File("D:\\学习资料\\java进阶13天资料\\copyTest\\1"), new File("D:\\学习资料\\java进阶13天资料\\copyTest\\2"));
    }

    //复制文件夹
    public static void copyDir(File srcDir, File desDir) throws IOException {
        //1、判断是否存在原路径，是否是文件夹
        if (srcDir.exists() && srcDir.isDirectory()) {
            //2、创建复制的目标文件夹
            desDir.mkdirs();
            //3、提取源文件夹的一级文件对象
            File[] files = srcDir.listFiles();
            //4、判断是否是以及文件对象
            if (files != null && files.length > 0) {
                //5、遍历
                for (File file : files) {
                    //6、判断是否是文件
                    if (file.isFile()) {
                        //7、直接复制到目标路径
                        copyFile(file, new File(desDir, file.getName()));
                    } else {
                        //8、file 是文件夹，递归复制 作为新的 destDir+新文件夹
                        copyDir(file, new File(desDir, file.getName()));
                    }
                }
            }
        }
    }

    //（4）使用高级的缓冲字节流按照一个一个字节数组的形式复制文件。
    public static void copyFile(File SRC_FILE, File DEST_FIlE) {
        long startTimer = System.currentTimeMillis();
        try (
                //创建一个低级的字节输入流与源文件联通
                InputStream inputStream = new FileInputStream(SRC_FILE);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                //创建一个低级的字节输出流管道与目标文件联通
                OutputStream outputStream = new FileOutputStream(DEST_FIlE);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        ) {
            //定义一个字节数组存储字节
            byte[] buffer = new byte[1024];
            //定义一个变量存储每次读取的字节数量
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTimer = System.currentTimeMillis();
        System.out.println("-------使用高级的缓冲字节流按照一个一个字节数组的形式复制文件。" + (endTimer - startTimer) / 1000.0);
    }
}

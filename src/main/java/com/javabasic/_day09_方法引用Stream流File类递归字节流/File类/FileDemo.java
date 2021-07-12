package com.javabasic._day09_方法引用Stream流File类递归字节流.File类;

/**
 * @ClassName FileDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/11 21:33
 * @Version 1.0
 * 目标：File类的概述和API
 **/

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/***
 *  *     File类：代表操作系统的文件对象。
 *  *     File类：是用来操作操作系统的文件对象的，删除文件，获取文件信息，创建文件（文件夹）...
 *  *     广义来说操作系统认为文件包含（文件和文件夹）
 *  *
 *  *     File类的创建文件对象的API:
 *  *          包：java.io.File
 *  *         （1）构造器：
 *  *             -- public File(String pathname):根据路径获取文件对象
 *  *             -- public File(String parent , String child):根据父路径和文件名称获取文件对象！
 *  *             -- public File(File parent , String child)
 *  *
 *  *     File类创建文件对象的格式:
 *  *         a.File f = new File("绝对路径/相对路径");
 *  *             绝对路径：从磁盘的的盘符一路走到目的位置的路径。
 *  *                 -- 绝对路径依赖具体的环境，一旦脱离环境，代码可能出错！！
 *  *                 -- 一般是定位某个操作系统中的某个文件对象。
 *  *             相对路径：不带盘符的。（重点）
 *  *                 -- 默认是直接相对到工程目录下寻找文件的。
 *  *                 -- 相对路径只能用于寻找工程下的文件。
 *  *                 -- 能用相对路径就应该尽量使用，可以跨平台！
 *  *
 *  *         b.File f = new File("文件对象/文件夹对象");
 *  *             广义来说：文件是包含文件和文件夹的。
 *  *     小结：
 *  *         创建文件对象可以用绝对路径也可以用相对路径。
 *  *         相对路径只能用于寻找工程下的文件。
 *  *         文件对象可以表示文件也可以表示文件夹！
 *
 *   - public String getAbsolutePath()  ：返回此File的绝对路径名字符串。
 *      - public String getPath()  ： 获取创建文件对象的时候用的路径           获取文件定义的时候使用的路径。
 *      - public String getName()  ： 返回由此File表示的文件或目录的名称。     带后缀。
 *      - public long length()  ：    返回由此File表示的文件的长度。           字节个数。
 *      - public boolean exists() ：此File表示的文件或目录是否实际存在。
 *      - public boolean isDirectory()：此File表示的是否为目录。              是文件夹返回true ,反之
 *      - public boolean isFile() ：此File表示的是否为文件                    是文件返回true ,反之
 *      - public boolean createNewFile() ：当且仅当具有该名称的文件尚不存在时，
 *               创建一个新的空文件。 （几乎不用的，因为以后文件都是自动创建的！）
 *      - public boolean delete() ：删除由此File表示的文件或目录。 （只能删除空目录，不能删除非空文件夹）
 *      - public boolean mkdir() ：创建由此File表示的目录。（只能创建一级目录）     D:/itcast/bbbb
 *      - public boolean mkdirs() ：可以创建多级目录（建议使用的）                  D:/itcast/bbbb/e/a/d/ds/fa
 *      - public String[] list()：
 *              获取当前目录下所有的"一级文件名称"到一个字符串数组中去返回。
 *      - public File[] listFiles()(常用)：
 *              获取当前目录下所有的"一级文件对象"到一个文件对象数组中去返回（重点）
 *      - 最后修改时间  long  dir.lastModified()
 */
public class FileDemo {
    public static void main(String[] args) {
        //1、创建文件对象，使用绝对路口
        // 文件路径分隔符：
        //      -- a.使用正斜杠： /
        //      -- b.使用反斜杠： \\
        //      -- c.使用分隔符API:File.separator
        //File f1 = new File("D:/itcast/图片资源/beautiful.jpg");
        //File f1 = new File("D:"+File.separator+"itcast"+File.separator+"图片资源"+File.separator+"beautiful.jpg");  跨平台用
        //File f1 = new File("C:\\Users\\bill\\Desktop\\壁纸\\wallhaven-01kemw.png");
        File file = new File("src\\main\\java\\com\\javabasic\\_day09_方法引用Stream流File类递归字节流\\text1.txt");
        System.out.println(file.length());

        // 2.文件夹对象
        File f2 = new File("src"); // 文件夹本身的大小 0 不是包含的大小
        System.out.println(f2.exists());

        File dir = new File("D:\\");
        System.out.println(Arrays.toString(dir.list()));
        System.out.println(Arrays.toString(dir.listFiles()));
        //最后修改时间
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dir.lastModified()));
    }
}

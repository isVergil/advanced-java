package com.javabasic.图书管理系统;

import java.util.*;

/**
 * @ClassName BookSystem
 * @Description TODO
 * @Author bill
 * @Date 2021/7/7 14:16
 * @Version 1.0
 * 目标：图书管理系统的开发。
 * <p>
 * 业务需求分析：
 * （1）查看全部书籍。query
 * （2）添加书本信息。add
 * （3）删除书本信息。delete
 * （4）修改书本信息。update
 * （5）退出系统。 exit
 * <p>
 * 书本信息的结构:
 * 类型                书名            价格        作者
 * ---------------------------------------------------
 * 言情小说
 * -----------------《金瓶梅》         99.9        阿猫
 * -----------------《红楼梦》         198.2       曹雪芹
 * 武侠小说
 * -----------------《三少爷的剑》      98.2        古龙
 * -----------------《神雕侠侣》        98.2        金庸
 * ------------------------------------------------------
 * 分析：
 * （1）定义一个书本类。
 * （2）定义一个集合表示图书馆用于存储书本信息数据：Map<String,List<Book>>。
 * （3）展示操作界面。
 * （4）完成相应功能。
 **/
public class BookSystem {

    public static final Map<String, List<Book>> BOOK_STORE = new HashMap<>();
    public static final Scanner SYS_SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        showCommand();
    }

    //展示操作界面
    private static void showCommand() {
        System.out.println("===============欢迎您进入系统===================");
        System.out.println("（1）查看全部书籍。query");
        System.out.println("（2）添加书本信息。add");
        System.out.println("（3）删除书本信息。delete");
        System.out.println("（4）修改书本信息。update");
        System.out.println("（5）退出系统。 exit");
        System.out.print("请您输入您的操作命令：");
        String command = SYS_SCANNER.nextLine();
        //判断用户想干啥
        switch (command) {
            case "query":
                queryBooks();
                break;
            case "add":
                addBook();
                break;
            case "delete":
                deleteBook();
                break;
            case "update":
                updateBook();
                break;
            case "exit":
                // 退出系统
                System.out.println("退出成功，期待您下次光临！");
                System.exit(0);
                break;
            default:
                System.err.println("您的命令输入有无，请重新确认！");
        }
        showCommand();
    }

    private static void deleteBook() {
        queryBooks();
        System.out.println("===============欢迎您进入删除书本业务=================");
        while (true) {
            System.out.print("请您输入删除书本的栏目：");
            String type = SYS_SCANNER.nextLine();
            if (BOOK_STORE.containsKey(type)) {
                System.out.println("请问您要删除的书本名称是");
                String name = SYS_SCANNER.nextLine();
                Book book = getBookByTypeAndName(type, name);
                if (book == null) {
                    System.err.println("不存在这本书！");
                } else {
                    //取出书
                    List<Book> books = BOOK_STORE.get(type);
                    books.remove(book);
                    System.out.println("删除成功");
                }
            } else {
                System.err.println("您输入的栏目不存在，请重新确认！");
            }
        }

    }

    private static void addBook() {
        System.out.println("===============欢迎您进入添加书本业务=================");
        System.out.print("请您输入添加书本的栏目：");
        String type = SYS_SCANNER.nextLine();
        List<Book> books = null;
        if (BOOK_STORE.containsKey(type)) {
            books = BOOK_STORE.get(type);
        } else {
            books = new ArrayList<>();
            BOOK_STORE.put(type, books);
        }
        System.out.println("请您输入添加书本的名称：");
        String name = SYS_SCANNER.nextLine();
        System.out.println("请您输入添加书本的价格：");
        String price = SYS_SCANNER.nextLine();
        System.out.println("请您输入添加书本的作者：");
        String author = SYS_SCANNER.nextLine();
        Book book = new Book(name, Double.valueOf(price), author);
        books.add(book);

    }

    private static void queryBooks() {
        System.out.println("===============欢迎您进入查询书本业务=================");
        if (BOOK_STORE.size() == 0) {
            System.out.println("您的图书馆一本书都没有，请赶紧买书去！");
        } else {
            System.out.println("类型\t\t\t\t书名\t\t\t\t\t价格\t\t\t作者");
            BOOK_STORE.forEach((type, books) -> {
                System.out.println(type);
                // 遍历该类型下的橱柜中的全部书本对象
                for (Book book : books) {
                    System.out.println("\t\t\t\t" + book.getName() + "\t\t\t" + book.getPrice() + "\t\t" + book.getAuthor());
                }
            });
        }
    }

    private static void updateBook() {
        if (BOOK_STORE.size() == 0) {
            System.out.println("您现在根本没有任何栏目可以修改!");
        } else {
            queryBooks();
            System.out.println("===============欢迎您进入修改书本业务=================");
            while (true) {
                System.out.print("请您输入修改书本的栏目：");
                String type = SYS_SCANNER.nextLine();
                // 1.判断是否存在该栏目
                if (BOOK_STORE.containsKey(type)) {
                    while (true) {
                        // 存在该栏目
                        // 2.请输入要修改的书名
                        System.out.print("请您输入修改书本的名称：");
                        String name = SYS_SCANNER.nextLine();
                        // 3.判断该栏目下是否存在该书本对象。
                        // 根据栏目和书名去栏目下查询出这本书对象
                        Book book = getBookByTypeAndName(type, name);
                        if (book == null) {
                            System.err.println("您的输入的书名不存在，，请重新确认！");
                        } else {
                            // 书名正确了，开始正式修改
                            System.out.println("请您输入修改书本的新名称：");
                            String newName = SYS_SCANNER.nextLine();
                            System.out.println("请您输入修改书本的新价格：");
                            String newPrice = SYS_SCANNER.nextLine();
                            System.out.println("请您输入修改书本的新作者：");
                            String newAuthor = SYS_SCANNER.nextLine();
                            book.setName(newName);
                            book.setPrice(Double.valueOf(newPrice));
                            book.setAuthor(newAuthor);
                            queryBooks();
                            System.out.println("您修改的书本成功，请看如上信息确认！");
                            return; // 结束修改的方法！
                        }
                    }
                } else {
                    // 不存在该栏目
                    System.err.println("您输入的栏目不存在，请重新确认！");
                }
            }
        }

    }

    /**
     * 在某个栏目下，根据书名查询出这本书对象返回！
     *
     * @param type 栏目名称
     * @param name 书名称
     * @return 书本对象
     */
    public static Book getBookByTypeAndName(String type, String name) {
        // 1.先提取这个栏目的橱柜，根据栏目提取它的值
        List<Book> books = BOOK_STORE.get(type);
        for (Book book : books) {
            // 如果本书的名称与要找的名称一样，该书就是我们要的，直接返回！
            if (book.getName().equals(name)) {
                return book;
            }
        }
        return null;// 没有这本书
    }
}

class Book {
    private String name;
    private double price;
    private String author;

    public Book() {
    }

    public Book(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}


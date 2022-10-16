package com.java8;

import com.java8.entity.Author;
import com.java8.entity.Book;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName StreamDemo
 * @Description TODO
 * @Author bill
 * @Date 2022/9/24 22:43
 * @Version 1.0
 **/
public class StreamDemo {

    /***
     ！！！注意事项
     1 惰性求值(如果没有终结操作，没有中间操作是不会得到执行的)
     2 流是一次性的(一旦一个流对象经过一个终结操作后。这个流就不能再被使用)
     3 不会影响原数据（我们在流中可以多数据做很多处理。但是正常情况下是不会影响原来集合中的元素的。这往往也是我们期望的)

     函数式接口 ： 只有一个抽象方法的接口 无论该接口是否加上了 @FunctionalInterface
     1、 Consumer 消费接口 accept
     2、 Function 计算转换接口 apply 将计算结果返回
     3、 Predicate 判断接口 test
     4、 Supplier  生产型接口  get

     方法引用：
     类名或者对象名::方法名

     基本数据类型优化：避免频繁装箱拆箱 mapToInt

     并行流： stream().parallel()  或者 parallelStream()
     当流中有大量元素时，我们可以使用并行流去提高操作的效率。
     其实并行流就是把任务分配给多个线程去完全。
     如果我们自己去用代i实现的话其实会非常的复杂，并且要求你对并发编程有足够的理解和认识。
     而如果我们使用Stream的话，我们只需要修改一个方法的调用就可以使用并行流来帮我们实现，从而提高效率。
     ### 用 peek 调试

     */
    public static void main(String[] args) {
        List<Author> authors = getAuthors();
        System.out.println(authors);
    }

    //创建 stream
    @Test
    public void test2() {
        List<Author> authors = getAuthors();
        //1 单列集合
        Stream<Author> stream = authors.stream();

        //2 数组（2种）
        Integer[] arr = {1, 2, 3, 4};
        Stream<Integer> stream1 = Arrays.stream(arr);
        stream1.forEach(System.out::println);
        Stream<Integer> stream2 = Stream.of(arr);
        stream2.forEach(System.out::println);

        //3 双列集合
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Stream<Map.Entry<String, Integer>> stream3 = set.stream();
        //stream3.forEach(a -> System.out.println(a.getKey() + ":" + a.getValue()));
        System.out.println(stream3.max(Comparator.comparingInt(Map.Entry::getValue)).get());

    }

    //中间操作
    @Test
    public void test3() {
        List<Author> authors = getAuthors();
        //filter 打印所有姓名长度大于2 的作家名字
        authors.stream()
                .filter(a -> a.getName().length() > 2)
                .forEach(a -> System.out.println(a.getName()));
        //map 打印所有作家的姓名
        authors.stream()
                .map(Author::getName)
                .forEach(System.out::println);
        //map 计算
        authors.stream()
                .map(author -> author.getAge())
                .map(age -> age + 10)
                .forEach(System.out::println);
        //distinct 打印所有的作家名称 不能有重复
        authors.stream()
                .distinct()
                .forEach(author -> System.out.println(author.getName()));
        //sorted 排序
        //sorted 空参,需要流中元素实现了 Comparable
        authors.stream()
                .distinct()
                .sorted()
                .forEach(author -> System.out.println(author.getAge()));
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .forEach(author -> System.out.println(author.getAge()));
        //对流中的元素按照年龄进行降序排序。并且要求不能有重复的元系,然后打印3其中年龄最大的两个作家的姓名.
        //limit 设置流的最大长度，超出的部分将会被抛弃掉
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .limit(2)
                .forEach(author -> System.out.println(author.getAge()));
        //打印滁了年龄最大的作家外的式他作家。要求不能有乖复元素，并且按照年龄降序笞序。
        //skip 跳过流中的 前 n 个元素，返回剩下的元素
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .skip(1)
                .forEach(author -> System.out.println(author.getAge()));

        //flatMap
        //map只能把一个对象转换成另一个对象来作为流中的元素。而flatMap可以把一个对象转换成多个对象作为流中的元素。
        //1 打印所有书解的名宇。要求对重复的素进行去乖。
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .forEach(book -> System.out.println(book.getName()));
        //2 打印现有教婚的所有分类。要求对分类进行去霜。不能出速这种格式:类别3,类别1
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(System.out::println);

    }

    //终结操作
    @Test
    public void test4() {
        List<Author> authors = getAuthors();

        //forEach 输出所有作家的名字
        authors.stream()
                .map(Author::getName)
                .distinct()
                .forEach(System.out::println);

        //count 输出所有书记的数目并去重
        long count = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .count();
        System.out.println(count);

        //max & min
        //输出 这些作家的书籍的最高分和最低分并打印
        Optional<Integer> max = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(author -> author.getScore())
                .max((a, b) -> a - b);
        System.out.println(max.get());
        Optional<Integer> min = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(author -> author.getScore())
                .min((a, b) -> a - b);
        System.out.println(min.get());

        //collect 把当前流转换成一个集合
        //1 获取一个存放所有作者名字的 list 集合
        List<String> names = authors.stream()
                .map(author -> author.getName())
                .collect(Collectors.toList());
        System.out.println(names);
        //2 获取所有书名的 set 集合
        Set<Book> books = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .collect(Collectors.toSet());
        System.out.println(books);
        //2 获取一个 map 集合，key 为作者名，value 为 List<Book>
        Map<String, List<Book>> map = authors.stream()
                .collect(Collectors.toMap(
                        new Function<Author, String>() {
                            @Override
                            public String apply(Author author) {
                                return author.getName();
                            }
                        }, new Function<Author, List<Book>>() {
                            @Override
                            public List<Book> apply(Author author) {
                                return author.getBooks();
                            }
                        }));
        System.out.println(map);

        //anyMatch
        //判断是否 有 年龄在29及以上的作家
        boolean anyMatch = authors.stream()
                .anyMatch(author -> author.getAge() >= 29);
        System.out.println(anyMatch);

        //allMatch
        //判断是否 都 符合匹配条件
        anyMatch = authors.stream()
                .allMatch(author -> author.getAge() >= 18);
        System.out.println(anyMatch);

        //noneMatch
        //判断是否 都不 符合匹配条件
        anyMatch = authors.stream()
                .noneMatch(author -> author.getAge() >= 29);
        System.out.println(anyMatch);

        //findAny
        //获取流中任意一个元素，不能保证是第一个元素
        Optional<Author> findAny = authors.stream()
                .filter(author -> author.getAge() > 18)
                .findAny();
        findAny.ifPresent(author -> System.out.println(author.getName()));

        //findFirst
        //获取流中第一个元素（获取年龄最小的作家，并输出他的姓名）
        authors.stream()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .findFirst().ifPresent(author -> System.out.println(author.getName()));


        //reduce 归并:聚合操作  先 map 再 reduce
        //对流中的数据按照你指定的计算方式计算出一个结果。I
        //作用是把stream中的元素给组合起来，我们可以传入一个初始值，
        //它会按照我们的计算方式依次拿流中的元素和初始化值的基础上进行计算，计算结果再和后面的元素计算。
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //求和
        int reduce = Arrays.stream(nums)
                .reduce(0, (res, ele) -> res + ele);
        System.out.println(reduce);
        //求最大值  两个参数
        reduce = Arrays.stream(nums)
                .reduce(Integer.MIN_VALUE, (res, element) -> res < element ? element : res);
        System.out.println(reduce);
        //求最小值  两个参数
        reduce = Arrays.stream(nums)
                .reduce(Integer.MAX_VALUE, (res, element) -> res > element ? element : res);
        System.out.println(reduce);
        //求最大值  一个参数
        OptionalInt reduce1 = Arrays.stream(nums)
                .reduce((res, element) -> res < element ? element : res);
        System.out.println(reduce1);
        //求最小值  两个参数
        OptionalInt reduce2 = Arrays.stream(nums)
                .reduce((res, element) -> res > element ? element : res);
        System.out.println(reduce2);

    }

    //Optional 的使用（避免空指针异常）
    //optional就好像是包装类，可以把我们的具体数据封装Optional对象内部。
    //然后我们去使用Optional中封装好的方法操作封装进去的数据就可以非常优雅的避免空指针异常。
    @Test
    public void test6() {
        Author author = new Author(2L, "cy", 18, "my introduction 1", null);

        //创建 Optional 对象
        //ofNullable 可接收空对象
        //of         不可接收空对象
        //一般写法：return author == null ? Optional.empty() : Optional.of(author);
        Optional<Author> authorOptional = Optional.ofNullable(author);

        //消费 Optional 对象
        //使用 ifPresent()
        authorOptional.ifPresent(author1 -> System.out.println(author1.getName()));

        //安全的获取 Optional 对象 值 : 有值直接返回，否则返回设置的默认值（这里是 new Author();）
        authorOptional.orElseGet(new Supplier<Author>() {
            @Override
            public Author get() {
                return new Author();
            }
        });
        //有值直接返回，否则抛出异常
        try {
            authorOptional.orElseThrow((Supplier<Throwable>) () -> new RuntimeException());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

    //并行流
    @Test
    public void Test7() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 35, 6, 342);
        Integer sum = stream.parallel()
                .peek(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer num) {
                        System.out.println(num + " " + Thread.currentThread().getName());
                    }
                })
                .filter(num -> num > 2)
                .reduce((res, ele) -> res + ele)
                .get();
        System.out.println(sum);
    }


    //打印所有年龄小于18的作家的名字,并且要注意去重
    @Test
    public void test1() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .filter(author -> author.getAge() < 18)
                .forEach(System.out::println);
    }


    // 初始化一些数据
    private static List<Author> getAuthors() {
        Author author1 = new Author(1L, "杨1", 18, "my introduction 1", null);
        Author author2 = new Author(2L, "杨26", 19, "my introduction 2", null);
        Author author3 = new Author(3L, "杨2", 14, "my introduction 3", null);
        Author author4 = new Author(4L, "杨40", 29, "my introduction 4", null);
        Author author5 = new Author(5L, "杨566", 12, "my introduction 5", null);

        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        // 上面是作者和书
        books1.add(new Book(1L, "书名1", "类别1", 45, "这是简介哦1"));
        books1.add(new Book(2L, "书名2", "类别2", 84, "这是简介哦2"));
        books1.add(new Book(3L, "书名3", "类别3", 83, "这是简介哦3"));
        books2.add(new Book(4L, "书名4", "类别4", 83, "这是简介哦4"));
        books2.add(new Book(5L, "书名5", "类别5", 65, "这是简介哦5"));
        books2.add(new Book(6L, "书名6", "类别6", 89, "这是简介哦6"));
        books3.add(new Book(7L, "书名7", "类别7", 45, "这是简介哦7"));
        books3.add(new Book(8L, "书名8", "类别8", 44, "这是简介哦8"));
        books3.add(new Book(9L, "书名9", "类别9", 81, "这是简介哦9"));

        author1.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);
        author5.setBooks(books2);

        List<Author> authors = new ArrayList<>(Arrays.asList(author1, author2, author3, author4, author5));

        return authors;
    }

}

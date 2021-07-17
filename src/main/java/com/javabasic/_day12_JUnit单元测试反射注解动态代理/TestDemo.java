package com.javabasic._day12_JUnit单元测试反射注解动态代理;

/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/17 14:12
 * @Version 1.0
 **/

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/***
 * 目标：单元测试的概念和操作步骤。
 *
 *      单元测试是指程序员写的测试代码给自己的类中的方法进行预期正确性的验证。
 *      单元测试一旦写好了这些测试代码，就可以一直使用，可以实现一定程度上的自动化测试。
 *
 *      单元测试一般要使用框架进行。
 *      什么是框架？
 *             -- 框架是前人或者一些牛逼的技术公司在实战或者研发中设计的一些优良的设计方案
 *                 或者成型的 代码功能，作为一个完整的技术体系发行出来称为框架。
 *
 *             -- 框架可以让程序员快速拥有一个强大的解决方案，可以快速的开发功能，提高效率
 *                并且直接就有了很好的性能。
 *
 *      单元测试的经典框架：Junit.
 *
 *      Junit是什么
 *          *  Junit是Java语言编写的第三方单元测试框架
 *          *  Junit框架的方案可以帮助我们方便且快速的测试我们的代码的正确性。
 *
 *      单元测试概念
 *          * 单元：在Java中，一个类就是一个单元
 *          * 单元测试：程序猿用Junit编写的一小段代码，
 *                       用来对某个类中的某个方法进行功能测试或业务逻辑测试。
 *
 *      Junit单元测试框架的作用
 *          * 用来对类中的方法功能进行有目的的测试，以保证程序的正确性和稳定性。
 *          * 能够独立的测试某个方法或者所有方法的预期正确性。
 *
 *      Junit框架的使用步骤:
 *         （1） 下载这个框架。（别人设计好的技术体系）
 *             框架一般是jar包的形式，jar包里面都是class文件。（Java工程的最终形式）
 *             class文件就是我们调用的核心代码。
 *
 *             -- 现在不需要大家去官网下载，因为很多知名框架其实IDEA工具早就整合好了，
 *                程序员可以直接使用。
 *
 *             Junit已经被IDEA下载好了，可以直接导入到项目使用的。
 *
 *         （2）直接用Junit测试代码即可
 *             a.先模拟业务代码
 *             b.写测试类
 *                     测试类的命名规范：以Test开头，以业务类类名结尾，使用驼峰命名法
 *                     业务名称是：UserService
 *                     测试这个业务类的测试类：TestUserService/UserServiceTest
 *             c.在测试类中写测试方法
 *                      测试方法的命名规则：以test开头，以业务方法名结尾
 *                      比如被测试业务方法名为：login，那么测试方法名就应该叫：testLogin
 *
 *             d.测试方法注意事项
 *                      必须是public修饰的，没有返回值，没有参数
 *                      必须使注解@Test修饰
 *
 *          (3)如何运行测试方法
 *                  * 选中方法名 --> 右键 --> Run '测试方法名'  运行选中的测试方法
 *                  * 选中测试类类名 --> 右键 --> Run '测试类类名'  运行测试类中所有测试方法
 *                  * 选中模块名 --> 右键 --> Run 'All Tests'  运行模块中的所有测试类的所有测试方法
 *
 *
 *          如何查看测试结果
 *              * 绿色：表示测试通过
 *              * 红色：表示测试失败，有问题
 *
 *          Junit常用注解(Junit 4.xxxx版本)
 *              * @Test 测试方法！
 *              * @Before：用来修饰实例方法，该方法会在每一个测试方法执行之前执行一次。
 *              * @After：用来修饰实例方法，该方法会在每一个测试方法执行之后执行一次。
 *              * @BeforeClass：用来静态修饰方法，该方法会在所有测试方法之前只执行一次。
 *              * @AfterClass：用来静态修饰方法，该方法会在所有测试方法之后只执行一次。
 *
 *             开始执行的方法:初始化资源。
 *             执行完之后的方法:释放资源。
 *
 *          Junit常用注解(Junit5.xxxx版本)
 *              * @Test 测试方法！
 *              * @BeforeEach：用来修饰实例方法，该方法会在每一个测试方法执行之前执行一次。
 *              * @AfterEach：用来修饰实例方法，该方法会在每一个测试方法执行之后执行一次。
 *              * @BeforeAll：用来静态修饰方法，该方法会在所有测试方法之前只执行一次。
 *              * @AfterAll：用来静态修饰方法，该方法会在所有测试方法之后只执行一次。
 */
public class TestDemo {
    public static void main(String[] args) {

    }

    @Before
    public void before() {
        //可以用来加载资源啥的 资源初始化
        //同理 @BeforeClass 只能修饰静态方法 初始化静态资源
        System.out.println("==============before==============");
    }

    @After
    public void after() {
        //可以用来释放资源啥的
        //同理 @AfterClass 只能修饰静态方法 释放静态资源
        System.out.println("==============after==============");
    }

    //测试方法的要求：
    //1.必须public修饰
    //2.没有返回值没有参数
    //3. 必须使注解@Test修饰
    @Test
    public void testLogin() {
        String result = new TestDemo().login("admin", "admin");
        //断言预期结果的正确性
        // * 参数一：测试失败的提示信息。
        // * 参数二：期望值。
        // * 参数三：实际值
        Assert.assertEquals("登录方法有误", "success", result);
    }

    @Test
    public void testChu() {
        new TestDemo().chu(10, 0);
    }

    public String login(String loginName, String passWord) {
        if ("admin".equals(loginName) && "admin".equals(passWord)) {
            return "success";
        }
        return "fail";
    }

    public void chu(int a, int b) {
        int c = a / b;
        System.out.println(c);
    }
}

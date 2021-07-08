package com.javabasic._day07_异常线程的创建方式线程安全线程同步;

/**
 * @ClassName CustomizeExceptionDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/8 18:39
 * @Version 1.0
 * 目标:自定义异常(了解)
 * ------------------------------
 * 引入:Java已经为开发中可能出现的异常都设计了一个类来代表.
 * 但是实际开发中,异常可能有无数种情况,Java无法为
 * 这个世界上所有的异常都定义一个代表类。
 * 假如一个企业如果想为自己认为的某种业务问题定义成一个异常
 * 就需要自己来自定义异常类.
 * ------------------------------------------
 * 需求：认为年龄小于0岁，大于200岁就是一个异常。
 * -------------------------
 * 自定义异常:
 * =====自定义编译时异常.
 * a.定义一个异常类继承Exception.
 * b.重写构造器。
 * c.在出现异常的地方用throw new 自定义对象抛出!
 * 编译时异常是编译阶段就报错，提醒更加强烈，一定需要处理！！
 * -------------------------
 * =====自定义运行时异常.
 * a.定义一个异常类继承RuntimeException.
 * b.重写构造器。
 * c.在出现异常的地方用throw new 自定义对象抛出!
 * 提醒不强烈，编译阶段不报错！！运行时才可能出现！！
 * 小结：
 * 自定义异常是程序员自己定义的异常
 * 继承Exception/RuntimeException，重写构造器。
 * 在出现异常的地方用throw new 自定义异常对象抛出!
 **/
public class CustomizeExceptionDemo {
    public static void main(String[] args) {
        try {
            checkAge(10);
        } catch (CustomizeCompileException e) {
            e.printStackTrace();
        }

        //提醒不强烈
        checkName("fsf");
    }

    private static void checkAge(int age) throws CustomizeCompileException {
        //出现异常
        // 出现异常了！
        // throws:用在方法上，用于抛出方法中的异常。
        // throw:用在出现异常的地方，用于创建异常对象且立即从此处抛出！
        if (age < 0 || age > 200) {
            throw new CustomizeCompileException("年龄出错");
        } else {
            System.out.println("fssf");
        }
    }

    private static void checkName(String name) {
        //出现异常
        // 出现异常了！
        // throws:用在方法上，用于抛出方法中的异常。
        // throw:用在出现异常的地方，用于创建异常对象且立即从此处抛出！
        if (name.length() < 0) {
            throw new CustomizeRuntimeException("名字出错");
        } else {
            System.out.println("fssf");
        }
    }
}

//自定义编译异常
class CustomizeCompileException extends Exception {
    public CustomizeCompileException() {
    }

    public CustomizeCompileException(String message) {
        super(message);
    }

    public CustomizeCompileException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomizeCompileException(Throwable cause) {
        super(cause);
    }

    public CustomizeCompileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

//自定义运行时异常
class CustomizeRuntimeException extends RuntimeException {
    public CustomizeRuntimeException() {
    }

    public CustomizeRuntimeException(String message) {
        super(message);
    }

    public CustomizeRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomizeRuntimeException(Throwable cause) {
        super(cause);
    }

    public CustomizeRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

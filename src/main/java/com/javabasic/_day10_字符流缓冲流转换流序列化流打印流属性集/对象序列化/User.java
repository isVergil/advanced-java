package com.javabasic._day10_字符流缓冲流转换流序列化流打印流属性集.对象序列化;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author bill
 * @Date 2021/7/15 16:25
 * @Version 1.0
 **/
public class User implements Serializable {
    // 加入序列版本号
    private static final long serialVersionUID = 1L;

    private String loginName;
    // transient修饰的成员变量，将不参与序列化！
    private transient String passWord;
    private String userName;

    public User() {
    }

    public User(String loginName, String passWord, String userName) {
        this.loginName = loginName;
        this.passWord = passWord;
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "loginName='" + loginName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}

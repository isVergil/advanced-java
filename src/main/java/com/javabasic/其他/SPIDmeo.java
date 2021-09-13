package com.javabasic.其他;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @ClassName SPIDmeo
 * @Description TODO
 * @Author bill
 * @Date 2021/9/11 20:39
 * @Version 1.0
 **/
public class SPIDmeo {
    public static void main(String[] args) {
        ServiceLoader<List> s = ServiceLoader.load(List.class);
        Iterator<List> iterator = s.iterator();
        System.out.println(iterator);
        while (iterator.hasNext()) {
            List search = iterator.next();
            System.out.println(search.hashCode());
        }
    }
}

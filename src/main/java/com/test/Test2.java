package com.test;

import lombok.val;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test2
 * @Description TODO
 * @Author bill
 * @Date 2021/7/22 21:00
 * @Version 1.0
 **/
public class Test2 {
    public static void main(String[] args) {
//        Test2 objectA = new Test2();
//        Test2 objectB = new Test2();
//        objectA.instance = objectB;
//        objectB.instance = objectA;
//        char[] temp = new char[128];
//        System.out.println(temp[0]);

        new Test2().combine(3,2);

        

    }

    List<List<Integer>> result;
    List<Integer> path;

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<List<Integer>>();
        path = new ArrayList<>();
        backtracking(n,k,1);
        return result;
    }

    void backtracking(int n, int k, int startIndex){
        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex; i <= n; i++ ) {
            path.add(i);
            backtracking(n,k,i + 1);
            path.remove(path.size() - 1);
        }
    }

//    public  static int[] fsff(){
//        List<Integer> tree = new ArrayList<>();
//        tree.add(123);
//        tree.add(123);
//        tree.add(123);
//        return tree.toArray();
//    }


}

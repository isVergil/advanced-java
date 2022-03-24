package com.algorithm.LeetCode热题HOT100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName LC20
 * @Description 20. 有效的括号
 * @Author bill
 * @Date 2022/3/20 14:57
 * @Version 1.0
 **/
public class LC20 {

    public static void main(String[] args) {
        System.out.println(new LC20().isValid("()"));
    }

    static Map<Character, Character> map = new HashMap();

    static {
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
    }

    public boolean isValid(String s) {
        //法1
        // while(s.contains("{}")||s.contains("()")||s.contains("[]")){
        //     s=s.replace("{}","");
        //     s=s.replace("()","");
        //     s=s.replace("[]","");
        // }
        // return s.isEmpty()

        //法2
//        Stack<Character> stack=new Stack<>();
//        int len=s.length();
//        for(int i=0;i<len;i++){
//            char c=s.charAt(i);
//            //左字符入栈
//            if(map.containsKey(c))
//                stack.push(c);
//            else{
//                if(stack.isEmpty())
//                    return false;
//                char left=stack.pop();
//                if(c!=map.get(left))
//                    return false;
//            }
//        }
//        return stack.isEmpty();

        if (s == null || s.length() == 0) {
            return false;
        }
        //入栈序列
        Stack<Character> stack = new Stack();
        //出栈序列
        Stack<Character> stack1 = new Stack();
        char[] sArray = s.toCharArray();
        for (char item : sArray) {
            stack.push(item);
        }
        while (!stack.isEmpty()) {
            if (stack1 == null) {
                stack1.push(stack.pop());
            }
            while (!stack.isEmpty() && !stack1.isEmpty() && map.get(stack.peek()) == stack1.peek()) {
                stack.pop();
                stack1.pop();
            }
            if (!stack.isEmpty()) {
                stack1.push(stack.pop());
            }
        }
        return stack.isEmpty() && stack1.isEmpty();




    }
}

package com.autumn.shence;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @ClassName Main1
 * @Description TODO
 * @Author bill
 * @Date 2022/10/13 19:30
 * @Version 1.0
 **/
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int N = (int) 1e6;
        List<Integer>[] distance = new List[N + 1];
        Arrays.setAll(distance, dis -> new ArrayList<Integer>(10));
        int num1 = 0, num2 = 0;
        for (int i = 0; i < n; i++) {
            num1 = sc.nextInt();
            num2 = sc.nextInt();
            distance[num1].add(num2);
            distance[num2].add(num1);
        }
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] point = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        deque.add(1);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int pollNum = deque.poll();
                for (int j : distance[pollNum]) {
                    if (!visited[j]) {
                        point[j] = pollNum;
                        visited[j] = true;
                        deque.offer(j);
                    }
                }
            }
        }
        visited = new boolean[N + 1];
        cal(visited, point, num1);
        System.out.println(cal(visited, point, num2));

    }

    static int cal(boolean[] visited, int[] point, int num) {
        for (int i = num; i >= 1; i = point[i]) {
            if (visited[i]) {
                return i;
            } else {
                visited[i] = true;
            }
        }
        return -1;
    }
}

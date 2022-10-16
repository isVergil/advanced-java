package com.algorithm.LeetCode热题HOT100;

import java.util.*;

/**
 * @ClassName LC207
 * @Description TODO
 * @Author bill
 * @Date 2022/4/2 16:02
 * @Version 1.0
 **/
public class LC207 {
    //法1 广度优先搜索
    //计算节点的入度和出度，入度为 0 表示可以休
    //依次遍历入度为 0 的节点，每遍历一个 入度为 0 的节点 其指向的节点出度 - 1
    //若不存在入度为 0 的节点 则存在环 则 return false  否则直到遍历完所有节点
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        //BFS
        while (!queue.isEmpty()) {
            int course = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(course)) {
                if (--indegrees[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
        return numCourses == 0;
    }

    //法2 DFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        int[] flags = new int[numCourses];
        for (int[] cp : prerequisites) {
            adjacency.get(cp[1]).add(cp[0]);
        }
        //DFS
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, i)) {
                return false;
            }
        }
        return true;
    }

    //flags[i] == 0  ： 干净的，未被 DFS 访问
    //flags[i] == -1 ： 其他节点启动的 DFS 访问过了，路径没问题，不需要再访问了
    //flags[i] == 1  ： 本节点启动的 DFS 访问过了，一旦遇到了也说明有环了
    //false 表示不能被 DFS 即有环
    //true  表示能被 DFS 即无环
    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1) {
            return false;
        }
        if (flags[i] == -1) {
            return true;
        }
        flags[i] = 1;
        for (Integer j : adjacency.get(i)){
            if (!dfs(adjacency, flags, j)) {
                return false;
            }
        }
        //设置 -1 表示
        flags[i] = -1;
        return true;
    }

}

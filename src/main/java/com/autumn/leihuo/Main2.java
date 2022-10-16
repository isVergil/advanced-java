package com.autumn.leihuo;

import java.util.*;

/**
 * @ClassName Main2
 * @Description TODO
 * @Author bill
 * @Date 2022/9/18 19:35
 * @Version 1.0
 **/
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int ziyuan = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < ziyuan; j++) {
                list.add(sc.nextInt());
            }
            map.put(i, list);
        }
        List<Integer> cpu = new ArrayList<>();
        List<Integer> cpu1 = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < M; i++) {
            int type = sc.nextInt();
            Integer id = sc.nextInt();
            if (type == 1) {  // 请求 id 资源
                cpu.remove(id);
                loadSon(id, map, cpu1);
                res = Math.max(res, cpu.size());
            } else {    // 释放 id 资源
                unloadSon(id, map, cpu, cpu1);
            }

        }
        System.out.println(res);
    }

    private static void unloadSon(Integer id, Map<Integer, ArrayList<Integer>> map, List<Integer> cpu, List<Integer> cpu1) {
        //是请求的资源
        if (cpu.contains(id)) {
            boolean isYilai = false;
            for (Integer cur : map.get(id)) {
                if (cpu1.contains(cur)) {
                    isYilai = true;
                    break;
                }
            }
            if (!isYilai) {
                cpu.remove(id);
                cpu1.remove(id);
            }
        } else {
            boolean isYilai = false;
            for (Integer cur : map.get(id)) {
                if (cpu1.contains(cur)) {
                    isYilai = true;
                    break;
                }
            }
            if (!isYilai) {
                cpu.remove(id);
                cpu1.remove(id);
            }
        }
    }

    static void loadSon(Integer id, Map<Integer, ArrayList<Integer>> map, List<Integer> cpu) {
        if (map.get(id) == null) {
            if (!cpu.contains(id)) {
                cpu.add(id);
            }
        } else {
            if (!cpu.contains(id)) {
                cpu.add(id);
            }
            for (Integer son : map.get(id)) {  //加载 子
                if (cpu.contains(son)) {
                    continue;
                }
                cpu.add(son);
                loadSon(son, map, cpu);
            }
        }
    }
}

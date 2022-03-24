package com.algorithm.LeetCode热题HOT100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LC39
 * @Description 39. 组合总和
 * @Author bill
 * @Date 2022/3/22 17:26
 * @Version 1.0
 **/
public class LC39 {


    //1常规写法，没剪枝
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList();
        backtrack(candidates, new ArrayList(), 0, target, 0);
        return res;
    }

    public void backtrack(int[] candidates, List<Integer> list, int sum, int target, int startIndex) {
        if (sum > target) {
            return;
        }
        if (target == sum) {
            res.add(new ArrayList(list));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            list.add(candidates[i]);
            sum += candidates[i];
            //这里 startIndex = i 表示可重复
            backtrack(candidates, list, sum, target, i);
            list.remove(list.size() - 1);
            sum -= candidates[i];
        }
    }

    //2排序做剪枝
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        res = new ArrayList();
        //排序
        Arrays.sort(candidates);
        backtrack1(candidates, new ArrayList(), 0, target, 0);
        return res;
    }

    public void backtrack1(int[] candidates, List<Integer> list, int sum, int target, int startIndex) {
        if (sum > target) {
            return;
        }
        if (target == sum) {
            res.add(new ArrayList(list));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            //剪枝
            if (sum + candidates[i] > target) {
                return;
            }
            list.add(candidates[i]);
            sum += candidates[i];
            //这里 startIndex = i 表示可重复
            backtrack(candidates, list, sum, target, i);
            list.remove(list.size() - 1);
            sum -= candidates[i];
        }
    }

}

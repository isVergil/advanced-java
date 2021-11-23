package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LC46
 * @Description TODO
 * @Author bill
 * @Date 2021/11/15 21:41
 * @Version 1.0
 **/
/*
回溯算法 比纯暴力搜索强
1、组合   无序
2、切割
3、子集
4、排列   有序
5、棋盘   n皇后

循环 + 递归 解决问题 对应 for + dfs(backtrack) （使用递归来解决嵌套 for 循环的问题）
 */
public class LC46 {

    //无重复数字的排列
    //全排列问题
    //给定一个 不含重复数字 的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return result;
    }

    void backtracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    //无重复数字的组合
    //LC 77  组合 注意剪枝
    public List<List<Integer>> combine(int n, int k) {
        backtrack1(n, k, 1);
        return result;
    }

    private void backtrack1(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        //已经选择的元素个数：path.size();
        //还需要的元素个数为: k - path.size();
        //在集合n中 至多 要从该起始位置 : n - (k - path.size()) + 1，开始遍历
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            //for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtrack1(n, k, i + 1);   //注意是 i + 1 不是 startIndex + 1
            path.remove(path.size() - 1);
        }
    }

    //重复数字的组合 + 限制总和条件 (数组元素 可以无限制重复被选取)
    //LC 39  组合总和
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //先排序
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0);
        return result;
    }

    private void backtrack(int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            //剪枝 加上当前元素已经大于target 后面的元素就不用取了 直接 break
            if (sum + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, target, sum, i);   //不用i+1了，表示可以重复读取当前的数
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}

package com.nec.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> lists = pailie(nums);
        System.out.println(lists);
    }

    /**
     * 有n个排成一行的空格, 从左往右依次填入题目中给定的n个数, 每个数只使用一次
     */
    public static List<List<Integer>> pailie(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;

    }

    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            // 新建list 因为output后面被修改
            res.add(new ArrayList<>(output));
        }
        // 维护一个动态列表, i的左侧为已经填过的数, 右侧为还没有填的数
        for (int i = first; i < n; i++) {
            // 动态维护数组
            // swap用于交换列表中两个指定索引位置的元素
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 将列表还原
            Collections.swap(output, first, i);
        }
    }
}
package main.java.com.nec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhaoxuan
 * @Description: 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * @date 2023/7/26
 */
public class Leet46 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute.toString());
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        int len = nums.length;
        backTrack(len, output, ans, 0);
        return ans;
    }

    private static void backTrack(int len, List<Integer> output, List<List<Integer>> ans, int first) {
        // 所有数都填完了
        if (first == len) {
            ans.add(new ArrayList<>(output));
        }
        for (int i = first; i < len; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 递归填写下一个数
            backTrack(len, output, ans, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}

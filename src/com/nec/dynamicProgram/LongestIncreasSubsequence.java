package com.nec.dynamicProgram;

/**
 * 最长递增子序列
 * 给定一个整数数组nums, 找到其中最长递增子序列
 * [10,9,2,5,3,7,101,18]
 * 返回4, 最长递增子序列为[2,3,7,101]
 */
public class LongestIncreasSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int lengthOf = lengthOf(nums);
        System.out.println(lengthOf);
    }

    public static int lengthOf(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // dp数组表示整数数组索引处最长递增子序列长度
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            // 数组不为空, 至少都有一个递增子序列, 就是其本身
            dp[i] = 1;
            // 遍历小于索引i的
            for (int j = 0; j < i; j++) {
                // 如果索引i的值 大于 索引j的值, 那么索引j位置的最长自增子序列+1, 就为索引i出的最长递增子序列, 即为dp[i] = dp[j]+1
                // j在循环, 取小于索引i值的 所有 索引j的最大值, 即为 Max(dp[j1 ... jn] + 1)
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 取最大的dp[i]
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}

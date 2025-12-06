package com.nec.dynamicProgram;

/**
 * 打家劫舍
 * 一个小偷, 计划偷沿街的房屋, 每间房都藏有一定的现金, 如果两间相邻的房屋同一天晚上被偷, 则会触发报警
 * 给定一个代表每个房间存放金额的非负整数数组, 计算你不触发报警的情况下, 一夜之间能偷到的最高金额
 * 输入: [2,7,9,3,1]
 * 输出: 12
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int rob = rob(nums);
        System.out.println(rob);
    }

    /**
     * 对于每间房子k, 存在两个选项:
     * 偷窃k房间, 由于不能偷k-1房间, 则能偷到的总金额为前k-2房间的最大金额 + k房间的金额
     * 不偷k房间, 能偷到的总金额为前k-1间的最高金额
     * 即:
     * dp[i] = max(dp[i-2] + nums[i], dp[i-1])
     * 边界条件为:
     * dp[0] = nums[0]   只有一间房
     * dp[1] = max(nums[0], nums[1])   只有两间房
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        // dp数组存储的是到第i间房能偷到的最大金额
        // 走到最后一间房, 即length-1, 能偷到的最大金额即为结果
        int[] dp = new int[length];
        // 只有一间房
        dp[0] = nums[0];
        // 只有两间房
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];

    }

}

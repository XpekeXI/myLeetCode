package com.nec.dynamicProgram;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        coinChange(coins, 11);
    }


    /**
     * F(i) 为组成 i 金额所需要的最小硬币个数
     * 那么 F(i) = min( F(i - cj1), F(i - cj2),..., F(i - cjn) ) + 1, 其中 cjn 为每一枚硬币的面值
     * 取 剩最后一枚硬币 前 所有组合硬币个数的最小值, 再加最后一枚, 即为F(i)的值
     */
    public static int coinChange(int[] coins, int amount) {
        // 设置最大值, 是为了最后判断, 是否能够凑成总金额, 如果凑不成, 则最后dp[amount] = amount + 1
        // 不设置amount + 1, 设置为amount, 最后dp[amount] = amount不能判断是否凑成
        int max = amount + 1;
        // 用dp数组来记录, 金额小于amount时, 所需要的最少硬币个数
        // 索引0 -> 金额为0时所需要的硬币个数, 索引1 -> 金额为1时所需要的硬币个数, ...
        int[] dp = new int[amount + 1];
        // 填充dp数组, 所有值为金额 + 1
        Arrays.fill(dp, max);
        // 设置金额为0时, 所需硬币个数为0
        dp[0] = 0;
        // i表示金额, 金额递增
        for (int i = 1; i <= amount; i++) {
            // 遍历硬币的面值数组
            for (int j = 0; j < coins.length; j++) {
                // 如果硬币面值小于等于当前金额
                if (coins[j] <= i) {
                    // 如果硬币面值小于等于当前金额, 取 当前金额所需硬币个数 与 (当前金额 - 硬币面值)的金额所需硬币个数 + 1
                    // 即为上面的公式, 循环下来就依次取到了与 总金额 相差一个或多个的不同硬币面额的 所需要的所有硬币个数
                    // 相当于存起来了把当前问题拆分成小问题的所有解, 这就是动态规划的算法
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        // 最后判断总金额位置的硬币个数是否大于总金额, 因为设置的初始值是amount+1, 大于则是没有找到可凑的硬币
        return dp[amount] > amount ? -1 : dp[amount];
    }

}

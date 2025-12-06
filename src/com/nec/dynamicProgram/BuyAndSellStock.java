package com.nec.dynamicProgram;

/**
 * 买卖股票
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class BuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

    /**
     * 解法就是找到当前值与前面任意值的最大差值, 即为股票最大利润
     */
    public static int maxProfit(int[] prices) {
        int res = 0, minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            // 获取当前值前面所有值的最小值
            minPrice = Math.min(minPrice, prices[i]);
            // 获取当前值与最小值的差值, 并与最大利润比较
            res = Math.max(res, prices[i] - minPrice);
        }
        return res;
    }

}

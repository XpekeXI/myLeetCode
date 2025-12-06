package com.nec.dynamicProgram;

/**
 * 买卖股票2
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润
 */
public class BuyAndSellStock2 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

    public static int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            // 因为没有买卖次数限制, 只要今天比昨天的股票贵, 就可以获得利润
            res = res + Math.max(0, prices[i] - prices[i - 1]);
        }
        return res;
    }

}


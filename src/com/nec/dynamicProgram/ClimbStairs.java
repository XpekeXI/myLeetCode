package com.nec.dynamicProgram;

/**
 * 爬楼梯
 * 有n阶楼梯, 一次只能爬 1阶或者 2阶, 有多少爬法可以上去
 */
public class ClimbStairs {
    /**
     * 最后一步可以跨一阶, 也可以跨两阶, 则 f(x) = f(x-1) + f(x-2)
     */
    public static int climbStairs(int n) {
        /*
         * p表示到n-1阶有多少爬法
         * q表示到n-2阶有多少爬法
         * res为最后结果
         */
        int p = 0, q = 0, res = 1;
        // i表示当前爬到第几级楼梯
        for (int i = 1; i <= n; i++) {
            // 当循环从 i -> j(i+1), 则原来的 i-1 阶的爬法总数p, 变成了新的 j-2(i+1-2) 即为q, 将q的值赋值给p
            q = p;
            // 同样的, 原来的 i 阶的爬法总数 res, 变成了新的 j-1(i+1-1), 即为p, 将res的赋值给p
            p = res;
            // res 依然为 j-1阶爬法 + j-2阶爬法
            res = p + q;
        }
        return res;
    }
}

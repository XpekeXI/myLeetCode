package com.nec.dynamicProgram;

/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 2, 2, 1, 3, 1};
        int trap = trap(height);
        System.out.println(trap);
    }

    /**
     * 每根柱子能接到的雨水量, 为其左右两侧的最大值 leftMax, rightMax, 两值之间较小的值 减去 该柱子的高度
     *
     */
    public static int trap(int[] height) {
        int res = 0;
        // 指针下标
        int lk = 0, rk = height.length - 1;
        // 最大高度
        int leftMax = 0, rightMax = 0;
        while (lk < rk) {
            // 获取柱子左侧的最大值
            leftMax = Math.max(leftMax, height[lk]);
            // 获取柱子右侧的最大值
            rightMax = Math.max(rightMax, height[rk]);
            // 如果左侧最大值小, 则左侧最大值 - 该柱子高度
            if (leftMax < rightMax) {
                res += leftMax - height[lk];
                // 因为左侧较小, 所以左指针移动, 因为决定雨水高度的是较小值
                // 左指针递增
                lk++;
            } else {
                res += rightMax - height[rk];
                // 右指针递减
                rk--;
            }
        }
        return res;
    }
}


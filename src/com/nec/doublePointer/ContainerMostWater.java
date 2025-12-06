package com.nec.doublePointer;

/**
 * @author zhaoxuan
 * @Description:    盛最多水的容器
 * @date 2023/7/15
 *
 * 给定一个长度为n的整型数组height, 有n条垂直线,
 * 求可以盛多少水
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 */
public class ContainerMostWater {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int maxArea = maxArea(height);
        System.out.println(maxArea);
    }

    /**
     * 盛水的数量 = 两根垂直线中较短的那根 * 两根垂直线的间距
     * 盛水最多, 即为数组中 某两个值较小的那个 * 这个值下标之差 最大
     * 初始时, 左右指针分别指向数组的两端, 此时需要考虑移动哪个指针, 由于水的高度是由两个值中最小的决定的,
     * 则如果较小值对应的指针不动, 较大值对应的指针移动都不会超过最初的容量, 所以每次移动的是较小值对应的指针
     *
     * 空间复杂度:
     * 最多遍历数组中所有元素, O(n)
     * 空间复杂度:
     * 只需要额外常数级别的空间, O(1)
     */
    public static int maxArea(int[] height) {

        int len = height.length;
        int lk = 0, rk = len - 1, ans = 0;
        while (lk < rk) {
            // 计算两个指针之间的面积
            int area = Math.min(height[lk], height[rk]) * (rk-lk);
            ans = Math.max(ans, area);
            // 如果左指针较小
            if (height[lk] < height[rk]) {
                // 左指针右移
                lk++;
            } else {
                // 否则, 右指针左移
                rk--;
            }
        }
        return ans;
    }

}

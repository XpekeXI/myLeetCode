package com.nec;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值
 * 给定一个整数数组nums, 有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧, 你只可以看到在滑动窗口内的k个数字
 * 滑动窗口每次只向右移动一位
 * 返回滑动窗口的最大值
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 */
public class SlidingWindowMax {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] window = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(window));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] ans = new int[length - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

}


package com.nec.doublePointer;

import java.util.Arrays;

/**
 * 移动零
 * 给定一个数组nums, 编写一个函数将所有0移动到数组的末尾, 同时保持非零元素的相对顺序
 * 必须在不复制数组的情况下原地对数组进行操作
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        int[] moveZero = moveZero(nums);
        System.out.println(Arrays.toString(moveZero));
    }

    /**
     * 使用双指针, 左指针指向当前已经处理好的序列的尾部, 右指针指向待处理序列的头部
     * 右指针不断向右移动, 每次右指针指向非零数, 则将左右指针对应的数交换, 同时左指针右移
     * 有以下几个特点
     * 1. 左指针左边均为非零数
     * 2. 右指针左边直到左指针处均为零
     * 3. 每次交换, 都是将左指针的零与右指针的非零数交换, 且非零数的相对顺序并未改变
     */
    public static int[] moveZero(int[] nums) {
        int length = nums.length, left = 0, right = 0;
        while (right < length) {
            // 右指针会一直移动, 有非零数, 交换完, 左指针的左边都是非零, 左指针再移动
            // 左右指针之间都是零, 随着非零数的不断交换, 把这些零都带到最右侧
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
        return nums;
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}

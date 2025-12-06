package com.nec.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 最长连续序列
 * <p>
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 **/
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] arr = {100, 4, 99, 1, 3, 2};
        int longest = getLongest(arr);
        System.out.println(longest);
    }

    public static int getLongest(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // 使用哈希表, 将查找元素时间复杂度变为O(1)
        Set<Integer> numSet = new HashSet<>();
        for (int num : arr) {
            numSet.add(num);
        }
        int longestSteak = 0;
        for (int num : numSet) {
            // 先找到连续序列的起点
            if (!numSet.contains(num - 1)) {
                // 如果哈希表中不包含当前数字-1, 则当前数字可能是连续序列的起点, 或者一个不在连续序列中的值
                // 如果是连续序列的起点, 则后续还能找到num+1, num+2等; 如果有多个连续序列的话, 这样也可以取到最长的连续序列
                // 如果不在连续序列的值, 则没有num+1
                int currNum = num;
                // 当前连续序列为1
                int currSteak = 1;
                while (numSet.contains(currNum + 1)) {
                    currNum++;
                    currSteak++;
                }
                // 去当前连续序列与最长连续序列的最大值
                longestSteak = Math.max(longestSteak, currSteak);
            }
        }
        return longestSteak;
    }
}

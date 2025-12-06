package com.nec.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为K的子数组
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 */
public class SubSumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1,2,3,0,0,1,2,4};
        int arraySum = subArraySum(nums, 3);
        System.out.println(arraySum);
    }

    /**
     * 使用前缀和, 我们可以将问题转化为求解两个前缀和之差等于k的情况
     * 假设数组的前缀和数组为preSum, preSum[i]表示从数组起始位置到第i位置的元素之和
     * 那么任意的两个下标i和j(i<j), 如果preSum[j]-preSum[i]=k, 即从第i位置到第j位置的元素之和等于k
     * 通过遍历数组,计算每个位置的前缀和,并使用哈希表存储, key为前缀之和, value为该前缀之和出现的次数
     * 在遍历过程中, 我们检查是否存在preSum-k的前缀和
     * 如果存在, 说明从某个位置到当前位置的连续子数组的和为k, 我们将对应的次数累加到结果中
     *
     */

    public static int subArraySum(int[] nums, int k) {
        int ans = 0;
        int numSum = 0;
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            numSum += nums[i];
            if (map.containsKey(numSum -k)) {
                ans += map.get(numSum -k);
            }
            map.put(numSum, map.getOrDefault(numSum, 0) + 1);
        }
        return ans;
    }

}



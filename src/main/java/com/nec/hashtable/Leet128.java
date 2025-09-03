package main.java.com.nec.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:    最长连续序列
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 **/
public class Leet128 {

    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int consecutive = longestConsecutive(nums);
        System.out.println(consecutive);
    }


    /**
     * 由于需要满足时间复杂度为O(n), 第一步就需要先把数组中的所有数据拿到, 这一步就已经是O(n)了
     * 所以在比较的时候, 也不能超过O(n), 取巧的思想, 如果数字连续, 那么起始值 - 1肯定不在数组中, 这样就可以找出起始值了
     * 找最大连续, 则从起始值开始, 每次数字 + 1都在数组中
     */
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        // 这里放入set集合, 是为了方便后续的判断数组中是否存在需要的值
        for (int i : nums) {
            numSet.add(i);
        }

        int longSeries = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currNum = num;
                int currSeries = 1;

                while (numSet.contains(currNum + 1)) {
                    currNum++;
                    currSeries++;
                }
                longSeries = Math.max(longSeries, currSeries);
            }
        }
        return longSeries;
    }


}

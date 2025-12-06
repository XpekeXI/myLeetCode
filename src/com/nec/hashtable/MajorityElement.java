package com.nec.hashtable;

import java.util.Hashtable;
import java.util.Map;

/**
 * @Description:    多数元素
 * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例1：
 * 输入：nums = [3,2,3]
 * 输出：3
 *
 * 示例2：
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 **/
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int majorityElement = majorityElement2(nums);
        System.out.println(majorityElement);
    }

    /**
     * 使用hash表, 将数组中的元素和元素出现的次数放入map集合
     * 然后比较出现次数最大的元素, 返回即可
     */
    public static int majorityElement1(int[] nums) {

        Hashtable<Integer, Integer> table = new Hashtable<>();
        for (int num : nums) {
            if (table.containsKey(num)) {
                table.put(num, table.get(num) + 1);
            } else {
                table.put(num, 1);
            }
        }

        int maxKey = 0;
        int maxValue = 0;
        for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }
        return maxKey;

    }

    /**
     * 同归于尽消杀法, 遍历数组, 设置初始值(记为我方士兵), 每循环一次, 判断与当前值(我方士兵)是否一致, 一致则将统计值(我方士兵人数) + 1
     * 不一致, 则将统计值 - 1(我方与敌方士兵同归于尽), 如果统计值为0, 则记录当前值为我方士兵
     *
     */
    public static int majorityElement2(int[] nums) {

        int winner = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                winner = nums[i];
                count += 1;
                continue;
            }
            if (winner == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return winner;
    }

}

package com.nec.doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 给定一个整数数组, 判断是否存在三元数组 num[i], num[j], num[k]
 * 满足 i != j != k, 同时 num[i] + num[j] + num[k] = 0
 * 返回所有和为0的三元组, 数组顺序不重要
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    /**
     * 不重复即为 a<= b<= c
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        // 先对数组进行排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // 先遍历枚举a
        for (int first = 0; first < n; first++) {
            // 需要与上一次的枚举的不同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            // 目标值为 0 - nums[first], 三数之和为0, 则另两个数之和为 -nums[first]
            int target = -nums[first];
            // 枚举b
            for (int second = first + 1; second < n; second++) {
                // 同样需要与上一次枚举的数不同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 第二指针小于第三指针, 并且第二指针下标的值 + 第三指针下标的值 > target, 即a+b+c>0, 则第三指针左移
                // 因为值是递增的, 所有左移才能找到较小的c
                /*
                 * 该循环结束有三种条件:
                 * 1. 第二指针等于第三指针
                 * 2. nums[second] + nums[third] = target 满足条件, 取值
                 * 3. nums[second] + nums[third] < target, c值较小了, 提升b值, 即继续遍历b
                 */

                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                // 如果第二指针和第三指针重合, 则不会有a+b+c=0的三个数了, 可以退出循环了
                if (second == third) {
                    break;
                }
                // 如果有满足
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }
        }
        return res;
    }

}

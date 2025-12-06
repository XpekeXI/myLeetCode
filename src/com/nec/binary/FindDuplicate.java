package com.nec.binary;

/**
 *
 * @Description: 找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 *
 * 示例 1：
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * @date 2023/8/6
 */
public class FindDuplicate {

    public static void main(String[] args) {

    }

    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1, ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }

        }
        return ans;
    }

}

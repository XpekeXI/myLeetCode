package com.nec.doublePointer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhaoxuan
 * @Description:    无重复字符的最长子串
 * @date 2023/7/15
 *
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 */
public class LongestSubstring {

    public static void main(String[] args) {
        int length = lengthOfSubString("pwwkew");
        System.out.println(length);
    }

    public static int lengthOfSubString(String s) {
        // 出现的字符集合
        Set<Character> charSet = new HashSet<>();
        int n = s.length();
        // 右指针, 初始值为-1, 相当于在字符串左边界的左侧
        // 右指针表示连续子串的末尾下标
        int rightIndex = -1, result = 0;
        for (int leftIndex = 0; leftIndex < n; leftIndex++) {
            // 左指针向右移动一格, 移除一个字符
            if (leftIndex != 0) {
                charSet.remove(s.charAt(leftIndex - 1));
            }
            while (rightIndex + 1 < n && !charSet.contains(s.charAt(rightIndex + 1))) {
                charSet.add(s.charAt(rightIndex + 1));
                rightIndex++;
            }
            result = Math.max(result, rightIndex - leftIndex + 1);
        }
        return result;
    }
}

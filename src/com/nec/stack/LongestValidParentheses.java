package com.nec.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最长有效括号
 * <p>
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号 子串 的长度。
 * <p>
 * 左右括号匹配，即每个左括号都有对应的右括号将其闭合的字符串是格式正确的，比如 "(()())"。
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        int i = longest2("()(()())");
        System.out.println(i);
    }

    /**
     * 栈底表示 已经遍历过的元素中, 最后一个没有匹配的右括号下标
     */
    public static int longest1(String s) {
        int n = s.length();
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // 如果取到的字符是左括号, 入栈下标, 表示等待右括号匹配
            if (ch == '(') {
                stack.push(i);
            } else {
                // 如果取到的字符是右括号, 出栈下标, 表示该右括号已经匹配
                stack.pop();
                // 如果栈为空, 则表示当前右括号没有被匹配, 因为事先放入一个 -1 值, 将该右括号下标入栈, 这样栈底依然表示最后一个没有匹配的右括号下标
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    // 如果栈不为空, 用当前右括号下标 减去 栈顶元素(有效括号子串的第一个左括号的下标 - 1), 即为当前有效括号子串的长度
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    /**
     * 动态规划
     */
    public static int longest2(String s) {
        int res = 0;
        // 初始dp数组为字符串长度
        // dp数组存储的是 走到索引i时, 字符串的最长有效括号个数
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            // 如果遍历到的字符是 右括号
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    /*
                     * 判断左右括号相连的情况
                     */
                    // 前面的字符为左括号, 则这两个字符构成了一个有效括号
                    // i 大于等于2, 则将 i-2 的位置 有效括号个数 + 2
                    // i 小于2, 则说明是第一个有效括号, dp[i]为 0+2
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    /*
                     * 考虑多个左括号与多个右括号相连时的情况
                     * 需要找到 当前右括号 去掉中间相连的左右括号后, 其对应的左括号在哪里, 其索引为 i-dp[i-1]-1
                     * 需要 i-dp[i-1] > 0, 保证索引有效, 且 i-dp[i-1]-1 索引位置是左括号, 否则, 有效括号不再连续
                     */
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // 当 i-dp[i-1]-1 索引位置是左括号, 则表明, 从 i-dp[i-1]-1 到 i为有效的括号
                    // 下一步去判断 i-dp[i-1]-2 的位置的最长有效括号个数, 如果该位置也有有效括号, 则需要累加
                    // 依然需要保证 i-dp[i-1]-2 索引有效
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}



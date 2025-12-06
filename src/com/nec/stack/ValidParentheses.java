package com.nec.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        int n = s.length();
        // 如果字符串长度对2取余为1, 则不是2的倍数, 字符串无效
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // 如果拿到的字符是右括号, 栈为空或者栈顶的元素不是对应的左括号, 则字符串无效
            if (pairs.containsKey(ch)) {
                // peek查看栈顶元素
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                } else {
                    // pop, 出栈
                    stack.pop();
                }
            } else {
                // 拿到的字符是左括号, 入栈
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}

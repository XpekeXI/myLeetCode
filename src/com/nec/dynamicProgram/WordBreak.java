package com.nec.dynamicProgram;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 * 给定一个字符串s和一个字符串列表wordDict作为字典, 如果可以利用字典中出现的一个或多个单词拼接出s, 则返回true
 *
 * 不要求字典中出现的单词全部都使用, 并且字典中的单词可以重复使用
 * 输入: s="applepenapple", wordDict=["apple", "pen"]
 * 输出: true
 *
 * 输入: s="catsandog", wordDict=["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class WordBreak {
    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        boolean b = wordBreak(s, wordDict);
        System.out.println(b);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        // 将字典放入set, 防止重复
        Set<String> wordDictSet = new HashSet<>(wordDict);
        // dp数组表示字符串s前i个字符组成的字符串s[0, i-1]能否被空格拆分成若干个字典中出现的单词
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // dp[j]为true, 表示s[0,j-1)都在字符串字典中
                // wordDict.contains(s.substring(j, i)), 表示s[j,i)在字符串字典中
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    // 则截止到i-1都在字符串中
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}

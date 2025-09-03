package main.java.com.nec.doublePointer;

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
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class Leet3 {

    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("pwwkew");
        System.out.println(i);
    }

    /**
     * 以字符串 abcabcbb 为例, 找出从每一个字符开始的, 不包含重复字符的最长子串, 那么其中最长的那个字符串即为答案
     * 如:
     * 以 (a)bcabcbb 开始的最长字符串为 (abc)abcbb
     * 以 a(b)cabcbb 开始的最长字符串为 a(bca)bcbb
     *
     * 所以我们一次递增地枚举子串的起始位置, 那么子串的结束位置也是递增的.
     *
     * 使用两个指针表示字符串中的某个子串的左右边界, 其中左指针代表 枚举子串的起始位置, 而右指针子串的结束位置
     * 左指针每向右移动一格, 就枚举下一个字符作为起始位置
     * 右指针每向右移动一格, 就表示子串长度加1, 即可找出当前枚举位置的最长子串长度
     * 枚举所有字符结束, 那么也就找到了最长子串长度
     *
     * 时间复杂度:
     * 需要遍历字符串中所有字符, 以及子串的所有字符, 为O(n+m)
     * 空间复杂度:
     * 需要一个字符集合, 字符最多128个, 为O(n)
     *
     */
    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合, 记录每个字符是否出现过
        Set<Character> charSet = new HashSet<>();
        int len = s.length();
        // 右指针, 初始值为-1, 相当于我们在字符串左边界的左侧
        int rk = 0, ans = 0;
        for (int lk = 0; lk < len; lk++) {
            // 如果左指针不为0, 则表示左指针已经要向后移动
            if (lk != 0) {
                // 左指针向右移动一格, 移除一个字符
                charSet.remove(s.charAt(lk - 1));
            }
            // 当右指针小于字符串长度, 且字符集合中不包含当前字符
            while (rk < len && !charSet.contains(s.charAt(rk))) {
                // 添加当前字符到集合中
                charSet.add(s.charAt(rk));
                // 右指针向右移动
                rk++;
            }
            // 当不满足字符串集合不包含当前字符时, 即当前右指针的字符已经重复,
            // 则子串长度为 (右指针下标 - 1) - 左指针下标 + 1, 即右指针下标 - 左指针下标
            // 右指针下标 - 1 表示有效子串的最后一个下标
            ans = Math.max(ans, rk - lk);
        }
        return ans;
    }

}

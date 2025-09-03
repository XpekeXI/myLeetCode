package main.java.com.nec;

/**
 * @Description: 比较版本号
 *
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 *
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零。
 * 每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
 *
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。
 * 也就是说，修订号 1 和修订号 001 相等。
 * 如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 *
 * 返回规则如下：
 * 如果version1>version2返回1，
 * 如果version1<version2 返回 -1，
 * 除此之外返回 0。
 *
 * 示例 1：
 *
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
 * 示例 2：
 *
 * 输入：version1 = "1.0", version2 = "1.0.0"
 * 输出：0
 * 解释：version1 没有指定下标为 2 的修订号，即视为 "0"
 * 示例 3：
 *
 * 输入：version1 = "0.1", version2 = "1.1"
 * 输出：-1
 * 解释：version1 中下标为 0 的修订号是 "0"，version2 中下标为 0 的修订号是 "1" 。0 < 1，所以 version1 < version2
 *  
 *
 * 提示：
 *
 * 1 <= version1.length, version2.length <= 500
 * version1 和 version2 仅包含数字和 '.'
 * version1 和 version2 都是 有效版本号
 * version1 和 version2 的所有修订号都可以存储在 32 位整数 中
 *
 *
 * @Author: zhaoxuan
 * @Date: 2022-03-16 15:45
 **/
public class Leet165 {

    public static void main(String[] args) {
       String version1 = "1.01", version2 = "1.001.0";
        int i = compareVersion2(version1, version2);
        System.out.println(i);
    }

    /**
     * 使用Java函数解法
     */
    public static int compareVersion1(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        for (int i = 0; i < arr1.length || i < arr2.length; i++) {
            int x = 0, y = 0;
            if (i < arr1.length) {
                x = Integer.valueOf(arr1[i]);
            }
            if (i < arr2.length) {
                y = Integer.valueOf(arr2[i]);
            }
            if (x > y) {
                return 1;
            } else if (x < y) {
                return -1;
            }
        }
        return 0;
    }

    /**
     * 使用数组下标解法
     * 思路: 以.为间隔, 分段迭代处理, 一次迭代只处理一段; 在处理这段时, 也是通过迭代取所有的数, 按位乘10
     */
    public static int compareVersion2(String version1, String version2) {
        int length1 = version1.length();
        int length2 = version2.length();
        int n = 0, m =0;
        // 以.为间隔, 一次迭代处理一段
        while (n < length1 || m < length2) {
            int x = 0, y = 0;
            // 处理其中一段
            for (; n < length1 && version1.charAt(n) != '.'; n++) {
                // 按位乘10, 通过和0进行char比较, 得出该位的数值
                x = x * 10 + version1.charAt(n) - '0';
            }
            // 跳过"."
            n++;
            for (; m < length2 && version2.charAt(m) != '.'; m++) {
                // 按位乘10, 通过和0进行char比较, 得出该位的数值
                y = y * 10 + version2.charAt(m) - '0';
            }
            // 跳过"."
            m++;
            if (x > y) {
                return 1;
            } else if (x < y) {
                return -1;
            }
        }
        // 所有段比较完, 全相等, 返回0
        return 0;
    }

}

package com.nec.backtrack;

/**
 * 单词搜索
 * 给定一个m*n的二维字符网络 board 和一个字符串单词 word, 如果word存在于网络中, 返回true, 否则返回false
 * 单词必须按照字母顺序, 通过相邻的单元格内的字母构成
 * <p>
 * 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = "ABCCED"
 * 输出：true
 * <p>
 * 回溯是通过递归解决问题的算法思想. 适用于需要穷举所有可能的复杂问题, 比如排列, 组合, 子集, 棋盘等
 * 核心思想: 尝试所有的可能, 当发现某一解不符合时, 就进行回退到上一步, 然后选择其他路径, 直到遍历所有可能
 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        boolean abccd = exist(board, "ABCCED");
        System.out.println(abccd);
    }

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    // i 二维数组横向下标; j 二维数组纵向下标; k 字符串下标
    public static boolean dfs(char[][] board, String word, int i, int j, int k) {
        // 横向下标非法或者超过二维数组最大值; 纵向一样; 当前二维数组下标的字符不等于字符串下标的字符; 此时终止
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) {
            return false;
        }
        // 走到这里说明, 数组下标没有越界, 且在数组中找到了与字符串下标字符 相同的 字符
        if (k == word.length() - 1) {
            // 字符串下标走完了, 说明已完全匹配
            return true;
        }
        // 将二维数组下标对应的字符改为 空, 防止再次匹配到
        board[i][j] = '\0';
        // 分别向当前二维数组下标的 前后左右 去查找字符串的下个坐标, 使用或连接, 表示只需要找到一条路径即可
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1)
                || dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        // 还原矩阵值
        board[i][j] = word.charAt(k);
        return res;
    }
}



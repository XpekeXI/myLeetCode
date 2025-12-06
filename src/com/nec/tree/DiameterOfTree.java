package com.nec.tree;

/**
 * @Description: 二叉树的直径
 *
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 *
 * 两节点之间路径的 长度 由它们之间边数表示。
 *
 * 输入：root = [1,2,3,4,5]
 * 输出：3
 * 解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
 */
public class DiameterOfTree {

    private static int res = 0;

    public static void main(String[] args) {
        TreeNode t34 = new TreeNode(4, null, null);
        TreeNode t35 = new TreeNode(5, null, null);
        TreeNode t22 = new TreeNode(2, t34, t35);
        TreeNode t23 = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(1, t22, t23);
    }

    /**
     * 一条路径的长度为该路径经过的节点数减一, 则优先考虑dfs
     */
    public static int depth(TreeNode root) {
        dfs(root);
        return res;
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算左子树的节点数(节点数即树的深度)
        int lDepth = dfs(root.left);
        // 计算右子树的节点数
        int rDepth = dfs(root.right);
        // 因为最长路径可能不经过根节点, 则需要判断每个节点的最长路径, 与结果的对比
        // 左路径长度为 lDepth-1, 右路径长度为 rDepth-1, 加上该节点, 即为 lDepth-1 + rDepth-1 + 2 = lDepth + rDepth
        res = Math.max(res, lDepth + rDepth);
        // 左子树与右子树的节点数最大值, 加1, 即为该节点的最大节点数
        return Math.max(lDepth, rDepth) + 1;
    }

}

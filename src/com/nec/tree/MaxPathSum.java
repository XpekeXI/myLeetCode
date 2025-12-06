package com.nec.tree;

/**
 * 二叉树的最大路径和
 * 二叉树中的路径被定义为一条节点序列, 序列中每对相邻节点之间都存在一条边. 同一个节点在一条路径中至多出现一次, 该路径至少包含一个节点,且不一定经过根节点
 * 路径和是路径中各节点值的总和
 * 给定一个二叉树根节点root, 返回其最大路径和
 * <p>
 * 输入: root=[-10,9,20,null,null,15,7]
 * 输出: 42
 * 最优路径是15->20->7
 */
public class MaxPathSum {
    static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode t33 = new TreeNode(15, null, null);
        TreeNode t34 = new TreeNode(7, null, null);
        TreeNode t21 = new TreeNode(9, null, null);
        TreeNode t22 = new TreeNode(20, t33, t34);
        TreeNode root = new TreeNode(-10, t21, t22);
        int maxPathSum = maxPathSum(root);
        System.out.println(maxPathSum);
    }

    public static int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    /**
     * 求节点的最大贡献值
     * 由于每个节点只能有一条边, 所以该节点的最大贡献值, 就是其自身的值 + 左子节点或右子节点的最大贡献值的最大值
     * 需要判断最大贡献值是否大于零, 大于零时才选取其对应的子节点
     * <p>
     * 而节点的最大路径和, 为其自身的值 + 左子节点的最大贡献值 + 右子节点的最大贡献值
     */
    public static int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时, 才会选取对应的子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值与左右子节点的最大贡献值
        int price = node.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, price);
        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }

}

package com.nec.tree;

/**
 * @Description: 二叉树的最大深度
 *
 * 最大深度
 * 给定一个二叉树root, 返回其最大深度
 * 二叉树的最大深度, 是指从根节点到最远叶子节点的 最长路径上的节点数
 */
public class MaximumDepthTree {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        int depth = maxDepth(node3);
        System.out.println(depth);
    }

    /**
     *  递归, 当节点为空时, 深度为0; 然后依次判定其左子树和右子树的深度, 比较两个深度大小, 然后进行加1
     *  时间复杂度:
     *  遍历了所有节点, 为O(n)
     *  空间复杂度:
     *  和树的高度相关
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

}

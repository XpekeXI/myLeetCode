package com.nec.tree;

/**
 * @author zhaoxuan
 * @Description:    对称二叉树
 * @date 2023/7/13
 * <p>
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 */
public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(2);
        TreeNode node31 = new TreeNode(3);
        TreeNode node41 = new TreeNode(4);
        TreeNode node42 = new TreeNode(4);
        TreeNode node32 = new TreeNode(3);

        node21.left = node31;
        node21.right = node41;
        node22.left = node42;
        node22.right = node32;
        node1.left = node21;
        node1.right = node22;
        boolean symmetric = isSymmetric(node1);
        System.out.println(symmetric);
    }

    public static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    /**
     * 递归:
     * 如果一棵树的左子树和右子树是镜像对称的, 那么它就是对称的
     * 两棵树互为镜像的条件:
     * 1. 它们的根节点具有相同的值
     * 2. 每棵树的右子树都与另一棵树的左子树镜像对称
     * 时间复杂度:
     * 遍历了整棵树, 时间复杂度为O(n)
     * 空间复杂度:
     * 和递归使用的栈空间有关, 递归层数不超过n, 故渐进空间复杂度为O(n)
     */
    public static boolean check(TreeNode p, TreeNode q) {
        // 如果都为空, 则是对称的
        if (p == null && q == null) {
            return true;
        }
        // 如果只有一个为空, 则不是对称的
        if (p == null || q == null) {
            return false;
        }
        // 当前两个节点值相等, 并且任意节点一个左子树和另一个节点的右子树也对称
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}

package com.nec.tree;

import java.util.*;

/**
 * @Description: 二叉树的中序遍历
 * <p>
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * <p>
 * 二叉树：[3, 9, 20, 15, 18, null, 7],
 * <p>
 * 3
 * / \
 * 9  20
 * / \  \
 * 15 18  7
 */
public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode t34 = new TreeNode(4, null, null);
        TreeNode t35 = new TreeNode(5, null, null);
        TreeNode t36 = new TreeNode(6, null, null);
        TreeNode t37 = new TreeNode(7, null, null);
        TreeNode t22 = new TreeNode(2, t34, t35);
        TreeNode t23 = new TreeNode(3, t36, t37);
        TreeNode root = new TreeNode(1, t22, t23);
        List<Integer> list = inorder2(root);
        System.out.println(list);
    }

    /**
     * 递归方式
     */
    public static List<Integer> inorder1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        midOrder(root, res);
        return res;
    }

    // 中序, 就是把父节点放在中间遍历; 左右子树, 都是先左子子树
    // 前序, 父节点先遍历, 后序遍历, 父节点最后遍历
    public static void midOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        // 先遍历左子树
        midOrder(root.left, res);
        // 再遍历父节点
        res.add(root.val);
        // 最后遍历右子树
        midOrder(root.right, res);
    }

    /**
     * 迭代方式
     * 中序遍历是先左子树, 再父节点, 再右子树
     * 递归方式是有一个隐式栈, 迭代就把这个栈显式展示出来
     */
    public static List<Integer> inorder2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            // 从根节点开始, 把根节点及它的左子树的节点一次都压入栈中, 最上层为树的最左叶子节点, 紧接着是最左叶子节点的父节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            /*
             * 弹出左子节点, 把该节点加入集合中, 然后是其父节点
             * 如果其父节点有左子树, 依然将其压入栈中
             * 后面再弹出, 这样每个节点都是先左子树, 再右子树
             *
             */
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

}

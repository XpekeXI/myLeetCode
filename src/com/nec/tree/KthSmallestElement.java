package com.nec.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉搜索树中第K小的元素
 *
 * 给定一个二叉搜索树的根节点, 和一个整数K, 设计一个算法查找其中第k小的元素
 */
public class KthSmallestElement {
    public static void main(String[] args) {
        TreeNode t32 = new TreeNode(2, null, null);
        TreeNode t21 = new TreeNode(1, null, t32);
        TreeNode t24 = new TreeNode(4, null, null);
        TreeNode root = new TreeNode(3, t21, t24);

        int val = ksmallest(root, 2);
        System.out.println(val);
    }

    /**
     * 二叉搜索树有以下特征
     * 1.节点的左子树只包含小于当前节点的
     * 2.节点的右子树只包含大于当前节点的
     * 3.所有的左右子树自身也是二叉搜索树
     */
    // 二叉搜索树, 中序遍历即为从小到大的排列, 用迭代的方式遍历, 出栈k次即为 第k小的元素
    public static int ksmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            // 左子树入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }

}


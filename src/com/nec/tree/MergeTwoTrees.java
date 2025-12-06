package com.nec.tree;

import java.util.List;

/**
 * @author zhaoxuan
 * @Description:    合并二叉树
 * @date 2023/7/13
 *
 * 给你两棵二叉树： root1 和 root2 。
 *
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 *
 * 返回合并后的二叉树。
 *
 * 注意: 合并过程必须从两个树的根节点开始。
 *
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 */
public class MergeTwoTrees {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);

        node1.left = node3;
        node1.right = node2;
        node3.left = node5;

        TreeNode node22 = new TreeNode(2);
        TreeNode node21 = new TreeNode(1);
        TreeNode node23 = new TreeNode(3);
        TreeNode node24 = new TreeNode(4);
        TreeNode node27 = new TreeNode(7);

        node22.left = node21;
        node22.right = node23;
        node21.right = node24;
        node23.right = node27;

        TreeNode treeNode = mergeTrees(node1, node22);
        List<List<Integer>> levelOrder = LevelOrderTraversal.levelOrder(treeNode);
        System.out.println(levelOrder.toString());

    }

    /**
     * 两个二叉树的对应节点可能存在以下三种情况，对于每种情况使用不同的合并方式。
     *
     * 1. 如果两个二叉树的对应节点都为空，则合并后的二叉树的对应节点也为空；
     * 2. 如果两个二叉树的对应节点只有一个为空，则合并后的二叉树的对应节点为其中的非空节点；
     * 3. 如果两个二叉树的对应节点都不为空，则合并后的二叉树的对应节点的值为两个二叉树的对应节点的值之和，此时需要显性合并两个节点
     *
     */
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        // 当两个节点不为空的时候, 将两个节点相加组成新节点
        TreeNode merged = new TreeNode(root1.val + root2.val);
        // 新节点的左子树为两棵树合并后的结果
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }

}

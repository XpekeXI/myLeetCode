package com.nec.tree;

/**
 * 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
 * 所有节点的值均不相等, 两个节点不相同, 且都位于二叉树中
 *
 * 输入: root=[3,5,1,6,2,0,8,null,null,7,4] p=5 q=4
 * 输出: 5
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode t43 = new TreeNode(7, null, null);
        TreeNode t44 = new TreeNode(4, null, null);
        TreeNode t31 = new TreeNode(6, null, null);
        TreeNode t32 = new TreeNode(2, t43, t44);
        TreeNode t33 = new TreeNode(0, null, null);
        TreeNode t34 = new TreeNode(8, null, null);
        TreeNode t21 = new TreeNode(5, t31, t32);
        TreeNode t22 = new TreeNode(1, t33, t34);
        TreeNode root = new TreeNode(3, t21, t22);

        TreeNode node = dfs(root, t21, t44);
        System.out.println(node.val);
    }

    public static TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        // 如果root为空或者root与p或者q相等, 即root就是当前p和q节点的公共祖先
        if (root == null || root == p || root == q) {
            return root;
        }
        // 在左子树中查找p和q节点的公共祖先
        TreeNode left = dfs(root.left, p, q);
        // 在右子树中查找p和q节点的公共祖先
        TreeNode right = dfs(root.right, p, q);
        // 如果左右子树都找到了最近公共祖先, 则当前root就是最近公共祖先
        if (left != null && right != null) {
            return root;
        }
        // 只找到一个, 找到的那个就是公共祖先
        return left != null ? left : right;
    }

}

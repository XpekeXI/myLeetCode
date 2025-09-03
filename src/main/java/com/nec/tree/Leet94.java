package main.java.com.nec.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhaoxuan
 * @Description:    二叉树的中序遍历
 * @date 2023/7/13
 *
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * 二叉树：[3, 9, 20, 15, 18, null, 7],
 *
 *    3
 *   / \
 *  9  20
 * / \  \
 *15 18  7
 */
public class Leet94 {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node18 = new TreeNode(18);
        TreeNode node7 = new TreeNode(7);
        node9.left = node15;
        node9.right = node18;
        node20.right = node7;
        node3.left = node9;
        node3.right = node20;
        List<Integer> list = inorderTraversal(node3);
        System.out.println(list.toString());
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder1(result, root);
        return result;
    }

    /**
     * 递归方式
     * 中序遍历(以根节点位置来说, 前遍历根节点, 则为前序, 中遍历根节点, 则为中序): 先左子树 -> 根节点 -> 右子树
     * 对于每个子树来说, 同样是如此, 形成了天然的递归方式
     * 时间复杂度:
     * 由于每个节点都会遍历一遍, 则时间复杂度为O(n)
     * 空间复杂度:
     * 空间复杂度取决于栈的深度, 在二叉树为一条线时, 栈深度为O(n)
     */
    private static void inorder1 (List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }
        inorder1(result, node.left);
        result.add(node.val);
        inorder1(result, node.right);
    }

    /**
     * 迭代方式
     * 递归方式也可以用迭代方式展现出来, 区别在于递归隐式的维护了一个栈, 迭代就需要显示的维护
     * 时间复杂度:
     * 由于每个节点都会遍历一遍, 则时间复杂度为O(n)
     * 空间复杂度:
     * 空间复杂度取决于栈的深度, 在二叉树为一条线时, 栈深度为O(n)
     */
    private static List<Integer> inorder2 (TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // 新建一个显式的栈
        Stack<TreeNode> stack = new Stack<>();
        // 如果节点不为空或者栈不为空, 则继续遍历
        while (root != null || !stack.isEmpty()) {
            // 如果根节点不为空, 则将根节点进栈
            while (root != null) {
                stack.push(root);
                // 将根节点的左子树赋值为根节点
                root = root.left;
            }
            /**
             * 经过了上述的循环, 则将从根节点开始, 所有子树的左节点全部进栈, 最后一个进栈的是最左边的叶子节点
             */
            // 最左边叶子节点
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

}

package main.java.com.nec.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxuan
 * @Description: 二叉树展开为链表
 * @date 2023/7/13
 * <p>
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 */
public class Leet114 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;

        // int depth = maxDepth(node3);
        // System.out.println(depth);
    }

    /**
     * 将二叉树展开为单链表之后，单链表中的节点顺序即为二叉树的前序遍历访问各节点的顺序
     */
    public static void flatten(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        // 先将二叉树前序遍历
        preOrder(nodeList, root);
        // 再将遍历的结果放置在要返回的单链表中
        int size = nodeList.size();
        /**
         * 遍历的结果中, 所有的节点都是原来二叉树的节点, 集合第一个为root
         * 下面循环后, 节点中的链接关系改变, 链表的头节点依然为root
         */
        for (int i = 1; i < size; i++) {
            // 单链表的前驱节点
            TreeNode prev = nodeList.get(i-1);
            // 当前节点
            TreeNode curr = nodeList.get(i);
            prev.left = null;
            prev.right = curr;
        }

    }

    public static void preOrder(List<TreeNode> nodeList, TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历, 则每个子树根节点在前
        nodeList.add(root);
        preOrder(nodeList, root.left);
        preOrder(nodeList, root.right);
    }

}

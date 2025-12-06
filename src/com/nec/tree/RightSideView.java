package com.nec.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的右视图
 * <p>
 * 给定一个二叉树的根节点, 想象自己站在它的右侧, 按照从顶部到底部的顺序, 返回从右侧所能看到的节点值
 * 输入: root=[1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * <p>
 * 输入: root = [1,2,3,4,null,null,null,5]
 * 输出: [1,3,4,5]
 */
public class RightSideView {
    public static void main(String[] args) {
        TreeNode t41 = new TreeNode(5, null, null);
        TreeNode t31 = new TreeNode(4, t41, null);
        TreeNode t21 = new TreeNode(2, t31, null);
        TreeNode t22 = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(1, t21, t22);

        List<Integer> list = rightView(root);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static List<Integer> rightView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        dfs(root, 1, ans);
        return ans;
    }

    /**
     * 深度优先, i表示层级, 比较i与ans的大小, 可以判断是否把节点添加到结果中
     */
    public static void dfs(TreeNode node, int i, List<Integer> ans) {
        if (node == null) {
            return;
        }
        if (i > ans.size()) {
            ans.add(node.val);
        }
        // i++, 向下一层搜索, 层级加1
        i++;
        // 先找右节点, 是因为要看右视图, 如果右节点一直有值, 那么会加入的永远都是最右的节点, 如果有右节点没值, 也会找该右节点的左节点
        dfs(node.right, i, ans);
        // 接着找左节点, 如果当层右节点没值, 也会优先去找当层左节点的下层右节点
        dfs(node.left, i, ans);
    }
}


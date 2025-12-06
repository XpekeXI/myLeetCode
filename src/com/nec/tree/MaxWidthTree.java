package com.nec.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 二叉树最大宽度
 * 树的 最大宽度 是所有层中最大的 宽度
 * 两端点之间的null也计入宽度
 */
public class MaxWidthTree {
    static Map<Integer, Integer> LevelMin = new HashMap<>();

    public static void main(String[] args) {
        TreeNode t46 = new TreeNode(6, null, null);
        TreeNode t47 = new TreeNode(7, null, null);
        TreeNode t35 = new TreeNode(5, t46, null);
        TreeNode t39 = new TreeNode(9, t47, null);
        TreeNode t23 = new TreeNode(3, t35, null);
        TreeNode t22 = new TreeNode(2, null, t39);
        TreeNode root = new TreeNode(1, t23, t22);

        int width = widthOfBinaryTree2(root);
        System.out.println(width);

    }

    /**
     * 广度优先
     * 根据满二叉树的编号规则, 若根节点编号为u, 则其左节点编号为2u, 右节点编号为2u+1
     */
    public static int widthOfBinaryTree1(TreeNode root) {
        int res = 1;
        List<Pair<TreeNode, Integer>> arr = new ArrayList<>();
        arr.add(new Pair<>(root, 1));
        while (!arr.isEmpty()) {
            List<Pair<TreeNode, Integer>> tmp = new ArrayList<>();
            for (Pair<TreeNode, Integer> pair : arr) {
                TreeNode node = pair.node;
                Integer index = pair.index;
                if (node.left != null) {
                    tmp.add(new Pair<>(node.left, index * 2));
                }
                if (node.right != null) {
                    tmp.add(new Pair<>(node.right, index * 2 + 1));
                }
            }
            res = Math.max(res, arr.get(arr.size() - 1).index - arr.get(0).index + 1);
            arr = tmp;
        }
        return res;

    }

    static class Pair<T, I> {
        T node;
        I index;

        public Pair(T node, I index) {
            this.node = node;
            this.index = index;
        }
    }

    /**
     * 深度优先 dfs
     */
    public static int widthOfBinaryTree2(TreeNode root) {
        return dfs(root, 1, 1);
    }

    public static int dfs(TreeNode node, int depth, int index) {
        if (node == null) {
            return 0;
        }
        // 每一层先访问到的节点会是最左边的节点, 即每一层编号最小值
        LevelMin.putIfAbsent(depth, index);
        // index表示节点编号, 每一层节点最大编号减去最左边节点编号+1, 即为该层的宽度
        return Math.max(index - LevelMin.get(depth) + 1, Math.max(dfs(node.left, depth + 1, index * 2), dfs(node.right, depth + 1, index * 2 + 1)));
    }
}




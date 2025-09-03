package main.java.com.nec.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxuan
 * @Description:    二叉树的层序遍历
 * @date 2023/7/13
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 *
 */
public class Leet102 {

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
        List<List<Integer>> levelOrder = levelOrder(node1);
        System.out.println(levelOrder.toString());
    }

    /**
     * 递归
     * 时间复杂度:
     * 把所有节点都遍历了一遍, 所以为O(n)
     * 空间复杂度:
     * 与二叉树的高度有关
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 使用层数, 用来判定层数和小集合个数的比较
        int level = 1;
        levelOrderExtend(result, root, level);
        return result;
    }

    private static void levelOrderExtend(List<List<Integer>> result, TreeNode root, int level) {
        // 节点为空, 返回
        if (root == null) {
            return;
        }
        // 如果当前深度大于小集合个数, 则需要新增一个小集合用来放置节点值
        if (level > result.size()) {
            result.add(new ArrayList<>());
        }
        List<Integer> list = result.get(level - 1);
        // 将当前节点放入小集合中
        list.add(root.val);
        // 处理左子树
        levelOrderExtend(result, root.left, level+1);
        // 处理右子树
        levelOrderExtend(result, root.right, level+1);
    }



}

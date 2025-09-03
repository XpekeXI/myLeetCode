package main.java.com.nec.tree;

/**
 * @author zhaoxuan
 * @Description: 二叉树的直径
 * @date 2023/7/13
 * <p>
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * <p>
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * <p>
 * 两节点之间路径的 长度 由它们之间边数表示。
 * <p>
 * 输入：root = [1,2,3,4,5]
 * 输出：3
 * 解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
 */
public class Leet543 {

    private static int maxDep = 0;

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        int depth = diameterOfBinaryTree(node3);
        System.out.println(depth);
    }

    /**
     * 可以理解为, 查看每个节点的左子树深度和右子树深度, 两个深度相加, 最大的那个就是树的直径
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDep;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // 相比于104题, 仅多了这一步, 获取两个深度之和
        maxDep = Math.max(leftDepth + rightDepth, maxDep);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}

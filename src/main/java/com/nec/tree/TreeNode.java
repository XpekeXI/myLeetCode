package main.java.com.nec.tree;

/**
 * @author zhaoxuan
 * @Description:
 * @date 2023/7/13
 */
public class TreeNode {

    public static void main(String[] args) {
        int i = get();
        System.out.println(i);
    }

    private static int get() {
        try {
            return 1;
        } finally {
            return 2;
        }
    }

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

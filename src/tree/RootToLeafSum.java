package tree;

/**
 * Created by rajat on 6/22/16.
 */
public class RootToLeafSum {

    public int sumNumbers(TreeNode root) {
        return sumHelper(root, 0);
    }

    private int sumHelper(TreeNode node, int num) {
        if (node == null) return 0;
        int sum = num * 10 + node.val;
        if (node.left == null && node.right == null) return sum;
        return sumHelper(node.left, sum) + sumHelper(node.right, sum);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

package tree;

/**
 * Created by rajat on 6/22/16.
 */
public class RecoverTree {
    TreeNode a = null, b = null, pre = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        recoverUtil(root);
        if (a != null && b != null) {
            int tmp = a.val;
            a.val = b.val;
            b.val = tmp;
        }
    }

    private void recoverUtil(TreeNode node) {
        if (node == null) return;
        recoverUtil(node.left);
        if (a == null && pre.val > node.val) a = pre;
        if (a != null && pre.val > node.val) b = node;
        pre = node;
        recoverUtil(node.right);
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

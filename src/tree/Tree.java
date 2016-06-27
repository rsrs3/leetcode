package tree;

/**
 * Created by rajat on 6/21/16.
 */
public class Tree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lcaUtil(root, p, q);
    }

    private TreeNode lcaUtil(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return null;
        else if (node.val == p.val) return p;
        else if (node.val == q.val) return q;
        else if (node.val > p.val && node.val > q.val) return lcaUtil(node.left, p, q);
        else if (node.val < p.val && node.val < q.val) return lcaUtil(node.right, p, q);
        else return node;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

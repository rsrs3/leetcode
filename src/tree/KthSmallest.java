package tree;

import java.util.Stack;

/**
 * Created by rajat on 6/21/16.
 */
public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        int val = 0;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tNode = stack.pop();
                k--;
                if (k == 0) {
                    val = tNode.val;
                    break;
                }
                node = tNode.right;
            }
        }
        return val;
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

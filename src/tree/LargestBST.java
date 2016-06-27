package tree;

/**
 * Created by rajat on 6/21/16.
 */
public class LargestBST {

    public int largestBSTSubtree(TreeNode root) {
        return bstUtil(root).size;
    }

    private Pair bstUtil(TreeNode node) {
        if (node == null) return new Pair(true, 0);
        if (node.left == null && node.right == null) return new Pair(true, 1);
        Pair lVal = bstUtil(node.left);
        Pair rVal = bstUtil(node.right);
        if (!lVal.bst || !rVal.bst) return new Pair(false, Math.max(lVal.size, rVal.size));
        else {
            Pair p = new Pair();
            if (node.left == null) {
                p.size = rVal.size;
                if (node.val < node.right.val) {
                    p.bst = true;
                    p.size++;
                }
            } else if (node.right == null) {
                p.size = lVal.size;
                if (node.val > node.left.val) {
                    p.bst = true;
                    p.size++;
                }
            } else if (node.val > node.left.val && node.val < node.right.val) {
                p.bst = true;
                p.size = lVal.size + rVal.size + 1;
            } else {
                p.size = Math.max(lVal.size, rVal.size);
            }
            return p;
        }
    }

    private static class Pair {
        boolean bst;
        int size;

        Pair() {
        }

        Pair(boolean b, int l) {
            bst = b;
            size = l;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(5);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(8);
        root.right=new TreeNode(15);
        root.right.right=new TreeNode(7);
        System.out.println(new LargestBST().largestBSTSubtree(root));
    }
}

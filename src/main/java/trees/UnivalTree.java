package trees;

/**
 * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 * <p>
 * Given the root to a binary tree, count the number of unival subtrees.
 * <p>
 * For example, the following tree has 5 unival subtrees:
 * <p>
 * 0
 * / \
 * 1   0
 * / \
 * 1   0
 * / \
 * 1   1
 */
public class UnivalTree {
    private static int count = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(0);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(1);
        int count = countUnivalSubTrees(root);
        System.out.println(count);
    }

    private static int countUnivalSubTrees(TreeNode root) {
        countUnivalSubTreesUtil(root, 0);
        return count;
    }

    private static int countUnivalSubTreesUtil(TreeNode root, int val) {
        if (root == null) {
            return val;
        }

        int left = countUnivalSubTreesUtil(root.left, root.val);
        int right = countUnivalSubTreesUtil(root.right, root.val);
        if (left == right && left == root.val) {
            count++;
            return root.val;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}

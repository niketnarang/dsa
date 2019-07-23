package trees;

/**
 * Implement locking in a binary tree. A binary tree node can be locked or unlocked only if all of its descendants or ancestors are not locked.
 * <p>
 * Design a binary tree node class with the following methods:
 * <p>
 * is_locked, which returns whether the node is locked
 * lock, which attempts to lock the node. If it cannot be locked, then it should return false. Otherwise, it should lock it and return true.
 * unlock, which unlocks the node. If it cannot be unlocked, then it should return false. Otherwise, it should unlock it and return true.
 * You may augment the node to add parent pointers or any other property you would like. You may assume the class is used in a single-threaded program, so there is no need for actual locks or mutexes.
 * Each method should run in O(h), where h is the height of the tree.
 */
public class LockableBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.parent = root;
        root.left.left = new TreeNode(3);
        root.left.left.parent = root.left.left;
        root.left.right = new TreeNode(4);
        root.left.right.parent = root.left.right;

        System.out.println("Is node locked? " + isLocked(root.left));
        System.out.println("Locking the node: " + lock(root.left));
        System.out.println("Locking other node: " + lock(root));
        System.out.println("Is node locked? " + isLocked(root.left));
        System.out.println("Unlocking the node: " + unlock(root.left));
        System.out.println("Is node locked? " + isLocked(root.left));
    }

    private static boolean isLocked(TreeNode node) {
        return node.isLocked;
    }

    private static boolean lock(TreeNode node) {
        if (canLockOrUnlock(node)) {
            node.isLocked = true;

            TreeNode current = node.parent;
            while (current != null) {
                current.lockedDescendantsCount += 1;
                current = current.parent;
            }
            return true;
        }
        return false;
    }

    private static boolean unlock(TreeNode node) {
        if (canLockOrUnlock(node)) {
            node.isLocked = false;
            TreeNode current = node.parent;
            while (current != null) {
                current.lockedDescendantsCount -= 1;
                current = current.parent;
            }
            return true;
        }
        return false;
    }

    private static boolean canLockOrUnlock(TreeNode node) {
        if (node.lockedDescendantsCount > 0) {
            return false;
        }

        TreeNode current = node.parent;
        while (current != null) {
            if (current.isLocked) {
                return false;
            }
            current = current.parent;
        }
        return true;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        boolean isLocked;
        int lockedDescendantsCount;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.parent = null;
            this.isLocked = false;
            this.lockedDescendantsCount = 0;
        }
    }
}

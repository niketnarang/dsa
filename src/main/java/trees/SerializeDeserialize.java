package trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.
 * <p>
 * https://github.com/bephrem1/backtobackswe/blob/master/Trees%2C%20Binary%20Trees%2C%20%26%20Binary%20Search%20Trees/serializeDeserializeBinaryTree.java
 */
public class SerializeDeserialize {
    private static final String NULL_SYMBOL = "X";
    private static final String DELIMITER = ",";

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        String serializedTree = serialize(root);
        System.out.println(serializedTree);
        TreeNode result = deserialize(serializedTree);
        System.out.println(result.val + " " + result.left.val + " " + result.right);
    }

    private static String serialize(TreeNode root) {
        if (root == null) {
            return NULL_SYMBOL + DELIMITER;
        }

        String leftSubtree = serialize(root.left);
        String rightSubtree = serialize(root.right);
        return root.val + DELIMITER + leftSubtree + rightSubtree;
    }

    private static TreeNode deserialize(String data) {
        Queue<String> nodesLeftToMaterialize = new LinkedList<>(Arrays.asList(data.split(DELIMITER)));
        return deserializeHelper(nodesLeftToMaterialize);
    }

    private static TreeNode deserializeHelper(Queue<String> nodesLeftToMaterialize) {
        String valueForNode = nodesLeftToMaterialize.poll();
        if (NULL_SYMBOL.equals(valueForNode)) {
            return null;
        }

        assert valueForNode != null;
        TreeNode node = new TreeNode(Integer.valueOf(valueForNode));
        node.left = deserializeHelper(nodesLeftToMaterialize);
        node.right = deserializeHelper(nodesLeftToMaterialize);
        return node;
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

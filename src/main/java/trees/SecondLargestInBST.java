package trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SecondLargestInBST {
    @Test
    void test1() {
        BST tree = new BST();
        tree.add(50);
        tree.add(30);
        tree.add(20);
        tree.add(40);
        tree.add(70);
        tree.add(60);
        tree.add(80);
        Assertions.assertEquals(secondLargest(tree.root), 70);
    }

    int secondLargest(Node node) {
        Count count = new Count();
        secondLargestUtil(node, count);
        return count.data;
    }

    private void secondLargestUtil(Node node, Count count) {
        if (node == null || count.count >= 2) {
            return;
        }

        secondLargestUtil(node.right, count);
        count.count++;
        if (count.count == 2) {
            count.data = node.data;
            return;
        }
        secondLargestUtil(node.left, count);
    }
}

class Count {
    int count;
    int data;
}
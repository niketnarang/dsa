package trees;

class BST {
    Node root;

    BST() {
        this.root = null;
    }

    void add(int data) {
        this.root = addRecursion(this.root, data);
    }

    private Node addRecursion(Node node, int data) {
        if (node == null) {
            this.root = new Node(data);
            return this.root;
        }

        if (data < node.data) {
            node.left = this.addRecursion(node.left, data);
        } else {
            node.right = this.addRecursion(node.right, data);
        }
        return node;
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

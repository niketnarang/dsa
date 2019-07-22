package linkedlist;

/**
 * Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.
 * <p>
 * For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
 * <p>
 * In this example, assume nodes with the same value are the exact same node objects.
 * <p>
 * Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
 */
public class IntersectingLinkedList {
    public static void main(String[] args) {
        Node common = new Node(8);
        common.next = new Node(10);

        Node root1 = new Node(3);
        root1.next = new Node(7);
        root1.next.next = common;

        Node root2 = new Node(99);
        root2.next = new Node(1);
        root2.next.next = common;

        Node result = findIntersection(root1, root2);
        System.out.println(result.val);
    }

    private static Node findIntersection(Node root1, Node root2) {
        Node current1 = root1;
        Node current2 = root2;
        while (current1 != current2) {
            current1 = current1.next;
            current2 = current2.next;

            if (current1 == null) {
                current1 = root2;
            }

            if (current2 == null) {
                current2 = root1;
            }
        }
        return current1;
    }

    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}

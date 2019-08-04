package graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

class MinimumDistanceToEdge {

    @Test
    void test1() {
        int[][] matrix = {{1, 1, 1, 0, 1},
                {1, 0, 2, 0, 1},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}};
        int rows = 4;
        int cols = 5;
        //1 is blocked
        //0 possible path
        Node source = null;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 2) {
                    source = new Node(i, j, 0);
                    break;
                }
            }
        }
        int expectedMinSteps = 2;
        Assertions.assertEquals(minimumDistance(matrix, rows, cols, source), expectedMinSteps);
    }

    static int minimumDistance(int[][] matrix, int rows, int cols, Node source) {
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1 || matrix[i][j] == 2) {
                    visited[i][j] = true;
                    break;
                } else { // if the current row, col is 0
                    visited[i][j] = false;
                }
            }
        }


        Queue<Node> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.row == 0 || node.row == rows - 1 || node.col == 0 || node.col == cols - 1) {
                return node.steps;
            }

            if (isValidUp(matrix, rows, cols, node.row, node.col, visited)) {
                queue.add(new Node(node.row - 1, node.col, node.steps + 1));
                visited[node.row - 1][node.col] = true;
            }

            if (isValidDown(matrix, rows, cols, node.row, node.col, visited)) {
                queue.add(new Node(node.row + 1, node.col, node.steps + 1));
                visited[node.row - 1][node.col] = true;
            }

            if (isValidLeft(matrix, rows, cols, node.row, node.col, visited)) {
                queue.add(new Node(node.row, node.col - 1, node.steps + 1));
                visited[node.row][node.col - 1] = true;
            }

            if (isValidRight(matrix, rows, cols, node.row, node.col, visited)) {
                queue.add(new Node(node.row, node.col + 1, node.steps + 1));
                visited[node.row][node.col + 1] = true;
            }
        }
        return 0;
    }

    private static boolean isValidUp(int[][] matrix, int rows, int cols, int row, int col, boolean[][] visited) {
        return row - 1 >= 0 && matrix[row - 1][col] == 0 && !visited[row - 1][col];
    }

    private static boolean isValidDown(int[][] matrix, int rows, int cols, int row, int col, boolean[][] visited) {
        return row + 1 <= rows - 1 && matrix[row + 1][col] == 0 && !visited[row + 1][col];
    }

    private static boolean isValidLeft(int[][] matrix, int rows, int cols, int row, int col, boolean[][] visited) {
        return col - 1 >= 0 && matrix[row][col - 1] == 0 && !visited[row][col - 1];
    }

    private static boolean isValidRight(int[][] matrix, int rows, int cols, int row, int col, boolean[][] visited) {
        return col + 1 <= cols - 1 && matrix[row][col + 1] == 0 && !visited[row][col + 1];
    }

    static class Node {
        int row;
        int col;
        int steps;

        Node(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }
}
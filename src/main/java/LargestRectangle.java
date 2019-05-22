import java.util.Stack;

public class LargestRectangle {
    public static void main(String[] args) {
        int[] heights = {1, 2, 3, 4, 5};
        System.out.println(largestRectangle(heights));
    }

    private static long largestRectangle(int[] h) {
        Stack<Integer> stack = new Stack<>();
        long area, maxArea = 0L;
        int top, index;
        for (index = 0; index < h.length; index++) {
            if (stack.isEmpty() || h[stack.peek()] <= h[index]) {
                stack.push(index);
            } else {
                top = stack.pop();
                if (stack.isEmpty()) {
                    area = h[top] * index;
                } else {
                    area = h[top] * (index - stack.peek() - 1);
                }

                if (maxArea < area) {
                    maxArea = area;
                }
            }
        }

        while (!stack.isEmpty()) {
            top = stack.pop();
            if (stack.isEmpty()) {
                area = h[top] * index;
            } else {
                area = h[top] * (index - stack.peek() - 1);
            }
            if (maxArea < area) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}

package arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array, print the Next Greater Element (NGE) for every element.
 * The Next greater Element for an element x is the first greater element on the right side of x in array.
 * Elements for which no greater element exist, consider next greater element as -1.
 * The next greater elements should be printed in same order as input array.
 */
public class NextBigElement {
    public static void main(String[] args) {
        //int[] arr = {3,2,1};
        //int[] arr = {4, 5, 2, 25};
        int[] arr = {4, 5, 2, 25, 10};
        int[] res = nextGreaterElement(arr);
        Arrays.stream(res).forEach(a -> System.out.print(a + " "));
    }

    private static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }
}
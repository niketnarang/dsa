package arrays;

import java.util.Arrays;

/**
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 * <p>
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 */
public class ProductArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] res = productArray(arr);
        Arrays.stream(res).forEach(i -> System.out.print(i + " "));
    }

    private static int[] productArray(int[] arr) {
        int[] productLeft = new int[arr.length];
        int[] productRight = new int[arr.length];
        int[] product = new int[arr.length];

        int p = 1;
        for (int i = 0; i < arr.length; i++) {
            productLeft[i] = p;
            p = p * arr[i];
        }

        p = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            productRight[i] = p;
            p = p * arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            product[i] = productLeft[i] * productRight[i];
        }
        return product;
    }
}

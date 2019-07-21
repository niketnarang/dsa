package recursion;

import java.util.Arrays;

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * <p>
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 */
public class SubArraySum {
    private static int LENGTH = 2;
    private static int SUM = 17;

    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        isSumPresent(arr);
    }

    private static void isSumPresent(int[] arr) {
        int[] res = new int[LENGTH];
        isSumPresentUtil(arr, res, 0, 0);
    }

    private static void isSumPresentUtil(int[] arr, int[] res, int currentIndex, int index) {
        if (currentIndex == LENGTH) {
            long localSum = Arrays.stream(res).sum();
            if ((int) localSum == SUM) {
                System.out.println("Present");
            }
            return;
        }

        if (index >= arr.length) {
            return;
        }
        res[currentIndex] = arr[index];
        isSumPresentUtil(arr, res, currentIndex + 1, index + 1);
        isSumPresentUtil(arr, res, currentIndex, index + 1);
    }
}

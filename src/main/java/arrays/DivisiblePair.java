package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers and a number k, write a function that returns true if given array can be divided into pairs such that sum of every pair is divisible by k.
 * Examples:
 * <p>
 * Input: arr[] = {9, 7, 5, 3},
 * k = 6
 * Output: True
 * We can divide array into (9, 3) and
 * (7, 5). Sum of both of these pairs
 * is a multiple of 6.
 * <p>
 * Input: arr[] = {92, 75, 65, 48, 45, 35},
 * k = 10
 * Output: True
 * We can divide array into (92, 48), (75, 65)
 * and (45, 35). Sum of all these pairs is a
 * multiple of 10.
 * <p>
 * Input: arr[] = {91, 74, 66, 48}, k = 10
 * Output: False
 */
class DivisiblePair {
    private static boolean divisblePair(int[] arr, int k) {
        //not possible when there are odd number of elements
        if (arr.length % 2 != 0) {
            return false;
        }

        List<Integer> myList = new ArrayList<>();
        for (int value : arr) {
            myList.add(value % k);
        }

        for (int i : arr) {
            if (myList.contains(Math.abs((i % k) - k))) {
                myList.remove(new Integer(Math.abs((i % k) - k)));
                myList.remove(new Integer(i % k));
            }
        }
        return myList.isEmpty();
    }

    @Test
    void test1() {
        int[] arr1 = {92, 75, 65, 48, 45, 35};
        Assertions.assertTrue(divisblePair(arr1, 10));
    }

    @Test
    void test2() {
        int[] arr2 = {9, 7, 5, 3};
        Assertions.assertTrue(divisblePair(arr2, 6));
    }

    @Test
    void test3() {
        int[] arr3 = {91, 74, 66, 48};
        Assertions.assertFalse(divisblePair(arr3, 10));
    }
}

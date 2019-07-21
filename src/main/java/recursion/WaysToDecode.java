package recursion;

/**
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 * <p>
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 */
public class WaysToDecode {
    public static void main(String[] args) {
        String message = "111";
        int count = decodeWays(message, 0);
        System.out.println(count);
    }

    private static int decodeWays(String message, int index) {
        if (index >= message.length()) {
            return 1;
        }

        int totalWaysFromHere = 0;
        if (index + 1 <= message.length()) {
            String temp = message.substring(index, index + 1);
            if (isValid(temp)) {
                totalWaysFromHere += decodeWays(message, index + 1);
            }
        }

        if (index + 2 <= message.length()) {
            String temp = message.substring(index, index + 2);
            if (isValid(temp)) {
                totalWaysFromHere += decodeWays(message, index + 2);
            }
        }
        return totalWaysFromHere;
    }

    private static boolean isValid(String temp) {
        if (temp == null || temp.isEmpty()) {
            return false;
        }

        if (temp.charAt(0) == '0') {
            return false;
        }

        int value = Integer.parseInt(temp);
        return value >= 1 && value <= 26;
    }
}
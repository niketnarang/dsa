package recursion;

public class StringPermutations {
    public static void main(String[] args) {
        String str = "abcd";
        permute(str, 0, str.length() - 1);
    }

    private static void permute(String str, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            System.out.println(str);
        } else {
            for (int index = leftIndex; index <= rightIndex; index++) {
                str = swap(str, leftIndex, index);
                permute(str, leftIndex + 1, rightIndex);
            }
        }
    }

    private static String swap(String str, int left, int right) {
        char[] strArr = str.toCharArray();
        char temp = strArr[left];
        strArr[left] = strArr[right];
        strArr[right] = temp;
        return String.valueOf(strArr);
    }


}

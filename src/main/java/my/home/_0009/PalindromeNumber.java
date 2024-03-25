package my.home._0009;

public class PalindromeNumber {

    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = Integer.toString(x);
        int size = s.length();
        if (size <= 1) {
            return true;
        }
        char[] chars = s.toCharArray();
        for (int firstIndex = 0; firstIndex < size; firstIndex++) {
            int lastIndex = size - (firstIndex + 1);
            if (lastIndex >= 0 && chars[firstIndex] == chars[lastIndex]) {
                if (firstIndex == lastIndex || firstIndex > lastIndex) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
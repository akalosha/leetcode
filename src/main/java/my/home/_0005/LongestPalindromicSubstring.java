package my.home._0005;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int size = s.length();
        if (size <= 1) {
            return s;
        }
        int longestStringSize = -1;
        String longestString = "";
        char[] chars = s.toCharArray();
        for (int rootIndex = 0; rootIndex < size; rootIndex++) {
            for (int i = 0; i < size; i++) {
                int firstIndex = rootIndex - i + 1;
                int lastIndex = rootIndex + i + 1;
                if (firstIndex >= 0 && lastIndex < size && chars[firstIndex] == chars[lastIndex]) {
                    if (1 + i * 2 > longestStringSize) {
                        longestString = s.substring(firstIndex, lastIndex + 1);
                        longestStringSize = longestString.length();
                    }
                } else {
                    break;
                }
            }
            for (int i = 0; i < size; i++) {
                int firstIndex = rootIndex - i;
                int lastIndex = rootIndex + i + 1;
                if (firstIndex >= 0 && lastIndex < size && chars[firstIndex] == chars[lastIndex]) {
                    if (2 + i * 2 > longestStringSize) {
                        longestString = s.substring(firstIndex, lastIndex + 1);
                        longestStringSize = longestString.length();
                    }
                } else {
                    break;
                }
            }
        }
        return longestString;
    }
}
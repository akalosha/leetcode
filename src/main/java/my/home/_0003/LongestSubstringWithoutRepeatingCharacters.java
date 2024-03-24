package my.home._0003;

public class LongestSubstringWithoutRepeatingCharacters {


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        String tempLine = "";
        int maxSize = 0;
        for (char tempChar : s.toCharArray()) {
            tempLine += tempChar;
            int indexOf = tempLine.indexOf(tempChar);
            if (indexOf != tempLine.length() - 1) {
                tempLine = tempLine.substring(indexOf + 1);
            }

            if (maxSize < tempLine.length()) {
                maxSize = tempLine.length();
            }
        }
        return maxSize;
    }
}

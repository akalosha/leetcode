package my.home._0028;

public class FirstOccurrenceInString {

    public static void main(String[] args) {
        String haystack = "a";
        String needle = "a";
        System.out.println(strStr(haystack,needle));
    }

    public static int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
            for (int j = 0; j < needle.length() && haystack.charAt(i + j) == needle.charAt(j); j++) {
                if(j+1==needle.length()){
                    return i;
                }
            }
        }
        return -1;
    }
}
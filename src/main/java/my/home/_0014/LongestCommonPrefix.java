package my.home._0014;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"ab", "a"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String firstString = strs[0];
        if (firstString.length() == 0) {
            return "";
        }
        int length = strs.length;
        for (int i = 0; i < firstString.length(); i++) {
            String pref = firstString.substring(0, i + 1);
            for (int j = 1; j < length; j++) {
                if (!(strs[j].startsWith(pref))) {
                    return firstString.substring(0, i);
                }
            }
        }
        return firstString;
    }
}
package my.home._0017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        if (chars.length == 0) {
            return Collections.emptyList();
        }

        List<String> nextCombinations = letterCombinations(digits.substring(1));
        List<String> result = new ArrayList<>();
        for (char achar : getOptionsForNumber(chars[0])) {
            if (nextCombinations.isEmpty()) {
                result.add(String.valueOf(achar));
            } else {
                for (String str : nextCombinations) {
                    result.add(achar + str);
                }
            }
        }
        return result;
    }

    private static char[] getOptionsForNumber(char number) {
        return switch (number) {
            case '2' -> new char[]{'a', 'b', 'c'};
            case '3' -> new char[]{'d', 'e', 'f'};
            case '4' -> new char[]{'g', 'h', 'i'};
            case '5' -> new char[]{'j', 'k', 'l'};
            case '6' -> new char[]{'m', 'n', 'o'};
            case '7' -> new char[]{'p', 'q', 'r', 's'};
            case '8' -> new char[]{'t', 'u', 'v'};
            case '9' -> new char[]{'w', 'x', 'y', 'z'};
            default -> new char[]{};
        };
    }
}
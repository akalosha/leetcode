package my.home._0022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(generateParenthesis(n).toString());
    }

    public static List<String> generateParenthesis(int n) {
        return generate(n, 0, 0, 0, 0, "");
    }

    private static List<String> generate(int n, int openBrackets, int totalOpenBrackets, int closedBrackets, int totalClosedBrackets, String currentStr) {
        List<String> list = new ArrayList<>();
        if (n > totalOpenBrackets) {
            list.addAll(generate(n, openBrackets + 1, totalOpenBrackets + 1, closedBrackets, totalClosedBrackets, ")" + currentStr));
        }
        if (n > totalClosedBrackets && openBrackets > closedBrackets) {
            list.addAll(generate(n, openBrackets, totalOpenBrackets, closedBrackets + 1, totalClosedBrackets + 1, "(" + currentStr));
        }

        if (list.isEmpty()) {
            return Collections.singletonList(currentStr);

        } else {
            return list;
        }
    }
}
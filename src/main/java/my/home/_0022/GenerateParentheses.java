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
        List<StringBuilder> builders = generate(n, 0, 0, 0, 0, Character.MAX_VALUE);
        return builders.stream().map(StringBuilder::toString).toList();
    }

    private static List<StringBuilder> generate(int n, int openBrackets, int totalOpenBrackets, int closedBrackets, int totalClosedBrackets, char currentChar) {
        List<StringBuilder> builders = new ArrayList<>();
        if (n > totalOpenBrackets) {
            builders.addAll(generate(n, openBrackets + 1, totalOpenBrackets + 1, closedBrackets, totalClosedBrackets, ')'));
        }
        if (n > totalClosedBrackets && openBrackets > closedBrackets) {
            builders.addAll(generate(n, openBrackets, totalOpenBrackets, closedBrackets + 1, totalClosedBrackets + 1, '('));
        }

        if (builders.isEmpty()) {
            return Collections.singletonList(new StringBuilder().append(currentChar));

        } else {
            if (currentChar != Character.MAX_VALUE) {
                builders.forEach(builder -> builder.append(currentChar));
            }
            return builders;
        }
    }
}
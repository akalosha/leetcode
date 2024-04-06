package my.home._0020;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Integer> brakets = new Stack<>();
        for (char achar : s.toCharArray()) {
            if (achar == '(') {
                brakets.push(0);
            } else if (achar == ')') {
                if (brakets.isEmpty() || brakets.pop() != 0)
                    return false;
            } else if (achar == '{') {
                brakets.push(1);
            } else if (achar == '}') {
                if (brakets.isEmpty() || brakets.pop() != 1)
                    return false;
            } else if (achar == '[') {
                brakets.push(2);
            } else if (achar == ']') {
                if (brakets.isEmpty() || brakets.pop() != 2)
                    return false;
            }
        }

        return brakets.isEmpty();
    }
}
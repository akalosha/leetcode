package my.home._0008;

public class StringToInteger {
    public static void main(String[] args) {
        String s = "18446744073709551617";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        long res = 0;
        s = s.trim();
        char[] chars = s.toCharArray();
        Boolean isNegative = null;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];

            if (aChar == '-' && i == 0) {
                isNegative = Boolean.TRUE;
                continue;
            } else if (aChar == '+' && i == 0) {
                isNegative = Boolean.FALSE;
                continue;
            } else if (aChar == ' ') {
                break;
            }

            int digit = Character.digit(aChar, 10);
            if (digit >= 0) {
                res = res * 10 + digit;
            } else {
                break;
            }
            if (res >= Integer.MAX_VALUE) {
                break;
            }
        }
        res = isNegative == Boolean.TRUE ? res * -1 : res;
        if (res >= Integer.MAX_VALUE || res <= Integer.MIN_VALUE) {
            return isNegative == Boolean.TRUE ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return (int) res;
    }
}
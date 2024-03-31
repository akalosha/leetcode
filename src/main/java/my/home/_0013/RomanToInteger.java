package my.home._0013;

public class RomanToInteger {

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    private static String leftRomanPart;

    public static int romanToInt(String s) {
        leftRomanPart = s;
        String[] fourDischarge = new String[]{"M", "MM", "MMM"};
        String[] threeDischarge = new String[]{"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] twoDischarge = new String[]{"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] oneDischarge = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        int res = 0;

        res += exstractDiscarge(fourDischarge, 1000);
        res += exstractDiscarge(threeDischarge, 100);
        res += exstractDiscarge(twoDischarge, 10);
        res += exstractDiscarge(oneDischarge, 1);
        return res;
    }

    private static int exstractDiscarge(String[] fourDischarge, int multiplier) {
        for (int i = fourDischarge.length - 1; i >= 0; i--) {
            if (leftRomanPart.startsWith(fourDischarge[i])) {
                leftRomanPart = leftRomanPart.substring(fourDischarge[i].length());
                return multiplier * (i + 1);
            }
        }
        return 0;
    }
}
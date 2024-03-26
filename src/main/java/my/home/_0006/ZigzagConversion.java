package my.home._0006;

public class ZigzagConversion {

    public static void main(String[] args) {
        String s = "ABCD";
        int numRows = 2;
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1 || s == null || s.length() <= numRows) {
            return s;
        }

        char[] chars = s.toCharArray();
        StringBuilder[] rowBuilders = new StringBuilder[numRows];
        for (int row = 0; row < numRows; row++) {
            rowBuilders[row] = new StringBuilder();
        }

        int position = 0, step = 1;
        for (char ch : chars) {
            rowBuilders[position].append(ch);
            if (position == 0) {
                step = 1;
            } else if (position == numRows - 1) {
                step = -1;
            }
            position += step;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rowBuilders) {
            result.append(sb);
        }
        return result.toString();
    }
}
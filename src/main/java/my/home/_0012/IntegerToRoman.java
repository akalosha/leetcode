package my.home._0012;

public class IntegerToRoman {

    public static void main(String[] args) {
        int num = 58;
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        int division = (int) (Math.log10(num) + 1);
        StringBuilder res = new StringBuilder();
        int processedNumber = 0;
        while (division > 0) {
            int currentRemainder = (int) ((num - processedNumber) / Math.pow(10, division - 1));
            if (currentRemainder == 0) {
                division--;
                continue;
            }

            if (currentRemainder == 9) {
                res.append(getSmallRomanSymbolForDivision(division).repeat(10-currentRemainder));
                res.append(getSmallRomanSymbolForDivision(division+1));
            }
            else  if (currentRemainder > 5) {
                res.append(getMiddleRomanSymbolForDivision(division));
                res.append(getSmallRomanSymbolForDivision(division).repeat(currentRemainder-5));
            }
            else if (currentRemainder == 5) {
                res.append(getMiddleRomanSymbolForDivision(division));
            }
            else if (currentRemainder == 4) {
                res.append(getSmallRomanSymbolForDivision(division));
                res.append(getMiddleRomanSymbolForDivision(division));
            }
            else {
                res.append(getSmallRomanSymbolForDivision(division).repeat(currentRemainder));
            }
            division--;
            processedNumber += currentRemainder * Math.pow(10, division);
        }
        return res.toString();
    }

    private static String getSmallRomanSymbolForDivision(int division) {
        if (division == 1) {
            return "I";
        } else if (division == 2) {
            return "X";
        } else if (division == 3) {
            return "C";
        } else if (division == 4) {
            return "M";
        }
        throw new IllegalArgumentException("Wrong division:" + division);
    }

    private static String getMiddleRomanSymbolForDivision(int division) {
        if (division == 1) {
            return "V";
        } else if (division == 2) {
            return "L";
        }
        if (division == 3) {
            return "D";
        }
        throw new IllegalArgumentException("Wrong division:" + division);
    }
}
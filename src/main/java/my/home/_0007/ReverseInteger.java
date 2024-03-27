package my.home._0007;

public class ReverseInteger {

    public static void main(String[] args) {
        int x = 123;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        boolean isNegative = x < 0;
        if (isNegative) {
            x = x * -1;
        }
        StringBuilder builder = new StringBuilder();
        try {
            int result = Integer.parseInt(builder.append(x).reverse().toString());
            if (isNegative) {
                result = result * -1;
            }
            return result;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
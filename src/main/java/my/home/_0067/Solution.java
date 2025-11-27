package my.home._0067;

public class Solution {

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int moveToNext = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || moveToNext == 1)
        {
            if(i >= 0)
                moveToNext += a.charAt(i--) - '0';
            if(j >= 0)
                moveToNext += b.charAt(j--) - '0';
            stringBuilder.append(moveToNext % 2);
            moveToNext /= 2;
        }
        return stringBuilder.reverse().toString();
    }
}
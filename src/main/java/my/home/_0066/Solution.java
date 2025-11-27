package my.home._0066;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] digits = {9};  // represents the number 123
        System.out.println(Arrays.toString(plusOne(digits)));
    }


    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
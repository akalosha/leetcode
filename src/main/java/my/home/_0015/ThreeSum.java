package my.home._0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int secondIndex = i + 1;
            int lastIndex = length - 1;
            while (secondIndex < lastIndex) {
                int sum = nums[i] + nums[secondIndex] + nums[lastIndex];
                if (sum < 0) {
                    secondIndex++;
                } else if (sum > 0) {
                    lastIndex--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[secondIndex], nums[lastIndex]));
                    secondIndex++;
                    lastIndex--;
                    while (secondIndex < lastIndex && nums[secondIndex] == nums[secondIndex - 1]){
                        secondIndex++;
                    }
                    while (secondIndex < lastIndex && nums[lastIndex] == nums[lastIndex + 1]) {
                        lastIndex--;
                    }
                }
            }
        }
        return res;
    }
}
package my.home._0016;

import java.util.Arrays;

public class ThreeSumColest {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5};
        int target = -2;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums);
        int minSum = 0;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            int secondIndex = i + 1;
            int lastIndex = length - 1;
            while (secondIndex < lastIndex) {
                int sum = nums[i] + nums[secondIndex] + nums[lastIndex];
                int distanceAbc = Math.abs(sum - target);
                int distance = sum - target;
                if (distanceAbc < minDistance) {
                    minDistance = distanceAbc;
                    minSum = sum;
                }
                if (distance < 0) {
                    secondIndex++;
                } else if (distance > 0) {
                    lastIndex--;
                } else {
                    return minSum;
                }
            }
        }
        return minSum;
    }
}
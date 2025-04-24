package my.home._0033;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        if ((endIndex - startIndex) >= 4) {
            return searchTargetInInterval(nums, target, startIndex, endIndex);
        }
        return searchInSmallArray(nums, target, startIndex, endIndex);
    }

    private static int searchInSmallArray(int[] nums, int target, int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private static int searchTargetInInterval(int[] nums, int target, int startIndex, int endIndex) {
        int middleIndex = (endIndex + startIndex) / 2;
        int targetIndex = getTargetIndex(nums, target, startIndex, middleIndex);
        if (targetIndex == -1) {
            targetIndex = getTargetIndex(nums, target, middleIndex, endIndex);
        }
        return targetIndex;
    }

    private static int getTargetIndex(int[] nums, int target, int startIndex, int endIndex) {
        int leftItem = nums[startIndex];
        int rightItem = nums[endIndex];
        if (leftItem > rightItem || leftItem <= target && target <= rightItem) {
            if ((endIndex - startIndex) >= 4) {
                return searchTargetInInterval(nums, target, startIndex, endIndex);
            }
            return searchInSmallArray(nums, target, startIndex, endIndex);
        }
        return -1;
    }
}
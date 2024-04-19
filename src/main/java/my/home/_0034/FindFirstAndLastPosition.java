package my.home._0034;

import java.util.Arrays;

public class FindFirstAndLastPosition {

    public static void main(String[] args) {
        int[] nums = new int[]{-99999,-99998,-9999,-999,-99,-9,-1};
        int target = 0;
        System.out.println(Arrays.toString(Arrays.stream(searchRange(nums, target)).toArray()));
    }

    public static int[] searchRange(int[] nums, int target) {
        int coreIndex;
        if (nums.length == 0) {
            coreIndex = -1;
        }
        else if (nums.length == 1) {
            if (nums[0] == target) {
                coreIndex = 0;
            } else {
                coreIndex = -1;
            }
        } else {
            coreIndex = searchNumber(nums, target, 0, nums.length - 1);
        }
        int leftIndex = coreIndex;
        int rightIndex = coreIndex;
        if (coreIndex != -1) {
            for (int i = coreIndex; i >= 0 && nums[i] == target; i--) {
                leftIndex = i;
            }
            for (int i = coreIndex; i < nums.length && nums[i] == target; i++) {
                rightIndex = i;
            }
        }
        return new int[]{leftIndex, rightIndex};
    }

    private static int searchNumber(int[] nums, int target, int left, int right) {
        int middleIndex = (left + right) / 2;
        if (target == nums[middleIndex]) {
            return middleIndex;
        } else if (left + 1 == right) {
            if (target == nums[left]) {
                return left;
            } else if (target == nums[right]) {
                return right;
            }
            return -1;
        }
        if (target > nums[middleIndex]) {
            return searchNumber(nums, target, middleIndex, right);
        } else {
            return searchNumber(nums, target, 0, middleIndex);
        }
    }
}
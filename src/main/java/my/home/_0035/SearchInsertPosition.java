package my.home._0035;

public class SearchInsertPosition {

    public static void main(String[] args) {
        int nums[] = new int[]{1};
        System.out.println(searchInsert(nums, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 1) {
            return target <= nums[0] ? 0 : 1;
        }
        return searchIndex(nums, target, 0, nums.length - 1);
    }

    public static int searchIndex(int[] nums, int target, int left, int right) {
        int middleIndex = (left + right) / 2;
        if (target == nums[middleIndex]) {
            return middleIndex;
        }
        if (left + 1 == right) {
            if (target < nums[left]) {
                return left;
            }
            if (target > nums[right]) {
                return right + 1;
            }
            return right;
        }
        if (target > nums[middleIndex]) {
            return searchIndex(nums, target, middleIndex, right);
        } else {
            return searchIndex(nums, target, left, middleIndex);
        }
    }
}
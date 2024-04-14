package my.home._0027;

public class RemoveElement {

    public static void main(String[] args) {
        int nums[] = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int size = nums.length;
        int tempIndex = 0;
        for (int i = 0; i < size; i++) {
            if (nums[i] != val) {
                nums[tempIndex++] = nums[i];
            }
        }
        return tempIndex;
    }
}
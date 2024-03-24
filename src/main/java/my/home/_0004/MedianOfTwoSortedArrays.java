package my.home._0004;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        if (size % 2 == 1) {
            return findMedianItemByIndex((size - 1) / 2, false, nums1, nums2);
        } else {
            int tempIndex = size / 2;
            return findMedianItemByIndex(tempIndex - 1, true, nums1, nums2);
        }
    }

    private static double findMedianItemByIndex(int index, boolean includeNextForMedian, int[] nums1, int[] nums2) {
        int nums1Index = 0;
        int nums2Index = 0;
        int lastItem;
        boolean shouldStop;

        while (true) {
            shouldStop = index == (nums1Index + nums2Index);
            if (nums2Index == nums2.length || nums1Index != nums1.length && nums1[nums1Index] < nums2[nums2Index]) {
                lastItem = nums1[nums1Index];
                nums1Index++;
            } else {
                lastItem = nums2[nums2Index];
                nums2Index++;
            }

            if (shouldStop) {
                if (includeNextForMedian) {
                    return (lastItem + getMin(nums1Index, nums2Index, nums1, nums2)) / 2.0;
                } else {
                    return lastItem;
                }
            }
        }
    }

    private static int getMin(int index1, int index2, int[] nums1, int[] nums2) {
        if (index1 == nums1.length) {
            return nums2[index2];
        } else if (index2 == nums2.length) {
            return nums1[index1];
        }
        return Math.min(nums1[index1], nums2[index2]);
    }
}

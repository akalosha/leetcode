package my.home._0011;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = new int[]{1, 1, 1, 1, 1, 2, 1, 1, 2};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int maxWater = 0;
        int size = height.length;
        int left = 0;
        int right = size - 1;

        while (left < right) {
            int temp = Math.min(height[left], height[right]) * (right - left);
            if (temp > maxWater) {
                maxWater = temp;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}
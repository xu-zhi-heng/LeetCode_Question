package interview_150;


public class maxArea_11 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(nums));
    }

    public static int maxArea(int[] height) {
        int result = 0;

        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int count = right - left;
            int size = count * Math.min(height[left], height[right]);
            // 面积等于高度 * 宽度， left和right的变化都会导致宽度变小，所有利用贪心，要想面积最大，只有是高度高的才会导致面积更大
            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
            result = Math.max(result, size);
        }

        return result;














    }
}

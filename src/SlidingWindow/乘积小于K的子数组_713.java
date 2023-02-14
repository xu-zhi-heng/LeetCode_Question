package SlidingWindow;

public class 乘积小于K的子数组_713 {
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int counts = 0;
        int product = 1;
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            product = product * nums[right];
            while (product >= k) {
                product = product / nums[left];
                left++;
            }
            // 以 [left, right] 为区间的连续数 为 right - left + 1
            counts = counts + right - left + 1;
            right++;
        }

        return counts;
    }
}

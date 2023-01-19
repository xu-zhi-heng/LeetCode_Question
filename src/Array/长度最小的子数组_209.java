package Array;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class 长度最小的子数组_209 {
    public static void main(String[] args) {
        minSubArrayLen(7, new int[]{2,3,1,2,4,3});
    }
    // 滑动窗口
    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;

        while (end <= nums.length - 1) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

package interview_150;

import java.util.Arrays;

public class minSubArrayLen_209 {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        if (Arrays.stream(nums).sum() < target) {
            return 0;
        }
        int ans = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= target) {
                ans = Math.min(ans, right - left);
                sum = sum - nums[left];
                left++;
            }
        }
        return ans;
    }

}

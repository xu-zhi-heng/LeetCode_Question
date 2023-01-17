package Dynamic;

import java.util.Arrays;

public class 连续子数组的最大和 {
    public static void main(String[] args) {
        maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }

    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        dp[0] = nums[0];

        int maxValue = 0;

        for(int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxValue = Math.max(dp[i], maxValue);
        }

        System.out.println(Arrays.toString(dp));

        return maxValue;
    }
}

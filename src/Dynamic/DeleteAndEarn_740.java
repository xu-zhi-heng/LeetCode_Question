package Dynamic;

import java.util.Arrays;

public class DeleteAndEarn_740 {
    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{3,4,2}));
    }


    public static int deleteAndEarn(int[] nums) {
        int len = nums.length;
        int maxValue = nums[0];
        for (int i = 1; i < len; i++) {
            maxValue = Math.max(maxValue, nums[i]);
        }
        int[] sums = new int[maxValue + 1];
        for (int val : nums) {
            sums[val] += val;
        }
        int[] dp = new int[sums.length];
        dp[0] = sums[0];
        dp[1] = Math.max(sums[0], sums[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + sums[i], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}

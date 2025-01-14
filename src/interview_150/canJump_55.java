package interview_150;

public class canJump_55 {
    public static void main(String[] args) {

    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        // dp[i] 表示当前能跳到的最大位置
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 当前位置有两个选择：跳或不跳
            // 跳的话：   i + num[i]
            // 不跳的话： dp[i - 1]
            dp[i] = Math.max(dp[i - 1], i + nums[i]);
            if (dp[i] > nums.length - 1) {
                return true;
            }
            if (dp[i] == i) {
                return false;
            }
        }

        return true;
    }
}

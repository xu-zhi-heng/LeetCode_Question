package interview_150;

public class jump_45 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int end = 1;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + i);
            if (i == end) {
                end = dp[i];
                count++;
            }
        }
        return count;
    }
}

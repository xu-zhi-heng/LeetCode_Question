package Dynamic;

public class 使用最小花费爬楼梯_746 {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]);
            if (i < len) {
                dp[i] = dp[i] + cost[i];
            }
        }

        return dp[len];
    }
}

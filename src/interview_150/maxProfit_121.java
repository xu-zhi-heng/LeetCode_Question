package interview_150;

public class maxProfit_121 {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {
        // dp[][0]: 表示持有股票最大金额  dp[][0]: 表示不持有股票最大金额
        int[][] dp = new int[prices.length + 1][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;


        for (int i = 1; i < prices.length; i++) {
            // 第i天持有股票的最大金额为：前一天的最大金额或者今天买入的最大值
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            // 第i天不持有股票的最大金额为：前一天不持有的最大金额或者今天卖出股票的最大金额
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }


        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}

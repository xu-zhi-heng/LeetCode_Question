package interview_150;

public class maxProfit_122 {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        // 表示持有股票和不持有股票的最大值
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            // 如果当前要持有股票并且为最大值的话，要么是不买入，上一步的，要么就是买入，就需要减掉今天的股票价格
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            // 如果不持有股票的最大值： 要么是上一步的最大值，要么就是上一步持有股票的最大值加上卖出去的
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        // 肯定是最后卖出股票利润才最大，不卖肯定没钱
        return dp[prices.length - 1][1];
    }
}

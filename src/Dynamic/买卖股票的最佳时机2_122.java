package Dynamic;

public class 买卖股票的最佳时机2_122 {
    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        // dp[i][0]: 代表第i天手里没有股票时候的最大利润
        // dp[i][1]: 代表第i天手里有一只股票时候的最大利润
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}

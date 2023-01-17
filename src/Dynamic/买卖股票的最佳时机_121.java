package Dynamic;

public class 买卖股票的最佳时机_121 {
    public static void main(String[] args) {

    }

    /**
     * dp[i] 表示前i天的最大利润是多少
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int[] dp = new int[len];
        int minPrice = prices[0];
        for (int i = 1; i < len; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }
        return dp[len - 1];
    }
}

package Dynamic;

public class 礼物的最大价值_剑指Offer47 {
    // 动态规划 dp[i][j] 表示 从棋盘的左上角走到位置 (i,j)，最多可以拿到的礼物的价值
    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
                dp[i][j] += grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}

package Dynamic;
import java.util.HashMap;
/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */
public class 不同路径_62 {
    public static void main(String[] args) {

    }

    public static int uniquePaths(int m, int n) {
        HashMap<String, Integer> memo = new HashMap<>();
        return solve(m, n, memo);
    }

    public static int solve(int m, int n, HashMap<String, Integer> memo) {
        String key = m + "," + n;
        if (memo.containsKey(key)) return memo.get(key);
        if (m == 0 || n == 0) return 0;
        if (m == 1 && n == 1) return 1;
        memo.put(key, solve(m, n - 1, memo) + solve(m - 1, n, memo));
        return memo.get(key);
    }
}

package BFS;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class 岛屿数量_200 {
    public static void main(String[] args) {

    }

    // 解体思路， 广度优先bfs， 当遍历到 1 时，把和 1 相关的所有 1 都变为 0， 同时数量加一
    public static int numIslands(char[][] grid) {
        int count = 0;
        // 遍历数组
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    callBfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void callBfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        // 上下左右遍历
        callBfs(grid, i + 1, j);
        callBfs(grid, i - 1, j);
        callBfs(grid, i, j + 1);
        callBfs(grid, i, j - 1);
    }
}

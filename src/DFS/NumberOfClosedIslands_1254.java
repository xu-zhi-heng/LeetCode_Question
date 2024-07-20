package DFS;


import java.util.ArrayList;
import java.util.List;

public class NumberOfClosedIslands_1254 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,0,1,1,0,1,0,0,1,0},
                {1,1,0,1,1,0,1,1,1,0},
                {1,0,1,1,1,0,0,1,1,0},
                {0,1,1,0,0,0,0,1,0,1},
                {0,0,0,0,0,0,1,1,1,0},
                {0,1,0,1,0,1,0,1,1,1},
                {1,0,1,0,1,1,0,0,0,1},
                {1,1,1,1,1,1,0,0,0,0},
                {1,1,1,0,0,1,0,1,0,1},
                {1,1,1,0,1,1,0,1,1,0},
        };
        System.out.println(closedIsland(grid));
    }


    static List<String> visited = new ArrayList<>();
    public static int closedIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 如果这个是土地且并没有被访问过
                if (grid[i][j] == 0 && !visited.contains(i + "," + j)) {
                    result += dfs(i, j, grid);
                }
            }
        }
        return result;
    }

    public static int dfs(int i, int j, int[][] grid) {
        // 越界的情况
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length) {
            return 0;
        }
        // 如果当前这个没有被访问过或者当前的位置是水说明是正确的
        if (grid[i][j] == 1 || visited.contains(i + "," + j)) {
            return 1;
        }
        visited.add(i + "," + j);
        if (dfs(i + 1, j, grid) == 0 || dfs(i - 1, j, grid) == 0 ||
                dfs(i, j + 1, grid) == 0 || dfs(i, j - 1, grid) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

}

package DFS;
public class 岛屿的最大面积_LCR105 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(maxAreaOfIsland(grid));
    }

    static int area;
    public static int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    bfs(grid, visited, i, j);
                    ans = Math.max(ans, area);
                    area = 0;
                }
            }
        }
        return ans;
    }

    public static void bfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        if (!visited[i][j] && grid[i][j] == 1) {
            area++;
            visited[i][j] = true;
        } else {
            return;
        }
        bfs(grid, visited, i + 1, j);
        bfs(grid, visited, i - 1, j);
        bfs(grid, visited, i, j + 1);
        bfs(grid, visited, i, j - 1);
    }
}

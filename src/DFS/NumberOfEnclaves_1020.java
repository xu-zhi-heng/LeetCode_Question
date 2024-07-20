package DFS;

import java.util.ArrayList;
import java.util.List;

public class NumberOfEnclaves_1020 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,0,0,0},
                {1,0,1,0},
                {0,1,1,0},
                {0,0,0,0}
        };
        NumberOfEnclaves_1020 numberOfEnclaves_1020 = new NumberOfEnclaves_1020();
        System.out.println(numberOfEnclaves_1020.numEnclaves(grid));

    }
    static List<String> list = new ArrayList<>();
    public int numEnclaves(int[][] grid) {
        int result = 0;
        List<String> step = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (step.contains(i + "," + j)) {
                    continue;
                }
                if (grid[i][j] == 1 && dfs(i, j, grid) == 0) {
                    result += list.size();
                }
                if (!list.isEmpty()) {
                    step.addAll(list);
                    list.clear();
                }
            }
        }
        return result;
    }

    public int dfs(int i, int j, int[][] grid) {
        if (grid[i][j] == 1 &&
                (i + 1 >= grid.length || i - 1 < 0 || j + 1 >= grid[0].length || j - 1 < 0)) {
            return 1;
        }
        if (list.contains(i + "," + j) || grid[i][j] == 0) {
            return 0;
        }
        list.add(i + "," + j);
        if (dfs(i + 1, j, grid) == 1 ||
                dfs(i - 1, j, grid) == 1
                || dfs(i , j + 1, grid) == 1
                || dfs(i, j - 1, grid) == 1) {
            return 1;
        }
        return 0;
    }
}

package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PondSizesCLLI {
    public static void main(String[] args) {
        int[][] lands = new int[][]{
                {0,2,1,0},
                {0,1,0,1},
                {1,1,0,1},
                {0,1,0,1}
        };
        System.out.println(Arrays.toString(pondSizes(lands)));
    }

    static int result = 0;
    public static int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        int row = land.length;
        int column = land[0].length;
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (land[i][j] == 0 && !visited[i][j]) {
                    bfs(land, i, j, visited);
                    if (result != 0) {
                        list.add(result);
                        result = 0;
                    }
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        Arrays.sort(ans);
        return ans;
    }

    public static void bfs(int[][] land, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length) {
            return;
        }
        if (land[i][j] == 0 && !visited[i][j]) {
            result++;
            visited[i][j] = true;
        } else {
            return;
        }
        bfs(land, i + 1, j, visited);
        bfs(land, i - 1, j, visited);
        bfs(land, i, j + 1, visited);
        bfs(land, i, j - 1, visited);
        bfs(land, i - 1, j - 1, visited);
        bfs(land, i - 1, j + 1, visited);
        bfs(land, i + 1, j + 1, visited);
        bfs(land, i + 1, j - 1, visited);
    }
}

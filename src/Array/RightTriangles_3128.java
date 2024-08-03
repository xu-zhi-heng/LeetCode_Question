package Array;

import java.util.Arrays;

public class RightTriangles_3128 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,0,1},
                {1,0,0},
                {1,0,0}
        };
        System.out.println(numberOfRightTriangles(grid));
    }

    public static long numberOfRightTriangles(int[][] grid) {
        long ans = 0;
        int row  = grid.length;
        int column = grid[0].length;
        int[] oneOfRow = new int[row];
        int[] oneOfColumn = new int[column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    oneOfRow[i] += 1;
                    oneOfColumn[j] += 1;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    ans += (oneOfRow[i] - 1) * (oneOfColumn[j] - 1);
                }
            }
        }
        return ans;
    }
}

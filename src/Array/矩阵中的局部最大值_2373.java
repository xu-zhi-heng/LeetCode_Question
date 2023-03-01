package Array;

public class 矩阵中的局部最大值_2373 {
    public int[][] largestLocal(int[][] grid) {
        int[][] maxLocal = new int[grid.length - 2][grid.length - 2];

        for (int i = 0; i < maxLocal.length; i++) {
            for (int j = 0; j < maxLocal[i].length; j++) {
                int max = 0;
                for (int k = i; k < i + 3; k++) {
                    for (int g = j; g < j + 3; g++) {
                        max = Math.max(max, grid[k][g]);
                    }
                }
                maxLocal[i][j] = max;
            }
        }
        return maxLocal;
    }
}

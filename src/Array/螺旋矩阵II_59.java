package Array;

import java.util.Arrays;

public class 螺旋矩阵II_59 {
    public static void main(String[] args) {
        int[][] ints = generateMatrix(3);
        System.out.println(Arrays.toString(ints));
    }
    public static int[][] generateMatrix(int n) {
        if (n == 1) return new int[][]{{1}};

        int[][] Matrix = new int[n][n];
        int begin = 1;
        int end = n * n;

        int rowBegin = 0;
        int rowEnd = n - 1;
        int columnBegin = 0;
        int columnEnd = n - 1;

        while (begin <= end) {
            for (int i = columnBegin; i <= columnEnd; i++) {
                Matrix[rowBegin][i] = begin;
                begin++;
            }
            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; i++) {
                Matrix[i][columnEnd] = begin;
                begin++;
            }
            columnEnd--;

            if (rowBegin <= rowEnd) {
                for (int i = columnEnd; i >= columnBegin; i--) {
                    Matrix[rowEnd][i] = begin;
                    begin++;
                }
            }
            rowEnd--;

            if (columnBegin <= columnEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    Matrix[i][columnBegin] = begin;
                    begin++;
                }
            }
            columnBegin++;

        }
        return Matrix;
    }
}

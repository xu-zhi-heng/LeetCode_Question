package Array;

import java.util.Arrays;

public class 图像渲染_733 {
    public static void main(String[] args) {
        int[][] image = new int[][]{{0,0,0},{0,1,1}};
        int sr = 1;
        int sc = 1;
        int newColor = 1;

        int val = image[sr][sc];
        if(val != newColor) {
            dfs(image, sr, sc, newColor, val);
        }
        System.out.println(Arrays.deepToString(image));
    }
    public static void dfs(int[][] image, int sr, int sc, int newColor, int val) {
        if(sr >= image.length || sc >= image[0].length || sr < 0 || sc < 0 || image[sr][sc] != val) {
            return;
        }
        if(image[sr][sc] == val) {
            image[sr][sc] = newColor;
            dfs(image, sr - 1, sc, newColor, val);
            dfs(image, sr + 1, sc, newColor, val);
            dfs(image, sr, sc + 1, newColor, val);
            dfs(image, sr, sc - 1, newColor, val);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (color != image[sr][sc]) {
            search(image, sr, sc, color, image[sr][sc]);
        }
        return image;
    }

    public void search(int[][] image, int sr, int sc, int color, int val) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != val) {
            return;
        }
        image[sr][sc] = color;
        search(image, sr + 1, sc, color, val);
        search(image, sr - 1, sc, color, val);
        search(image, sr, sc + 1, color, val);
        search(image, sr, sc - 1, color, val);
    }
}

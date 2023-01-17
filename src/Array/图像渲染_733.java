package Array;

import java.util.Arrays;

public class 图像渲染_733 {
    public static void main(String[] args) {
        int[][] image = new int[][]{{0,0,0},{0,1,1}};
        int sr = 1;
        int sc = 1;
        int newColor = 1;


        int val = image[sr][sc];
        // 此处： 少了一处判断就不对了 ？？？
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
}

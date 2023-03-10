package DFS;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 可以攻击国王的皇后_1222 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new ArrayList<>();

        // 用一个boolean的数组来记录queen在的位置
        boolean[][] seen = new boolean[8][8];
        for (int[] queen : queens) {
            seen[queen[0]][queen[1]] = true;
        }

        // 通过双层循环可以列出上下左右对角线八个方向
        int[] directions = {-1, 0, 1};
        for (int dx : directions) {
            for (int dy : directions) {
                if (dx == 0 && dy == 0) continue;

                int x = king[0];
                int y = king[1];

                // 通过一个位置向一个方向寻找, 找到第一个queen存在的方向
                while (x + dx >= 0 && x + dx < 8 && y + dy >= 0 && y + dy < 8) {
                    x = x + dx;
                    y = y + dy;

                    if (seen[x][y]) {
                        result.add(Arrays.asList(x, y));
                        break;
                    }
                }
            }
        }

        return result;
    }

}

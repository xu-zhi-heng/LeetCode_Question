package Array;

import java.util.HashSet;

public class 有效的数独_36 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hashSet = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current_val = board[i][j];
                if (current_val != '.') {
                    // 如果 hashSet 中 有过这些数据， 是不能够添加进去的
                    if (!hashSet.add(current_val + "row" + i) ||
                            !hashSet.add(current_val + "column" + j) ||
                            !hashSet.add(current_val + "box" + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}

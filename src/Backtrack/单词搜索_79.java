package Backtrack;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class 单词搜索_79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(board, i, j, word, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     *
     * @param board: 二维数组
     * @param i： 当前数组中的坐标位置
     * @param j
     * @param word： 查找的单词
     * @param index： 单词中的第几个字符
     * @param visited: 数组元素是否被访问过
     * @return
     */
    public boolean search(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                board[i][j] != word.charAt(index) || visited[i][j]
        ) {
            return false;
        }
        visited[i][j] = true;
        if (search(board, i + 1, j, word, index + 1, visited) ||
                search(board, i - 1, j, word, index + 1, visited) ||
                search(board, i, j + 1, word, index + 1, visited) ||
                search(board, i, j - 1, word, index + 1, visited)
        ) {
            return true;
        }
        // 如果不成功，那就将所有位置重新设置为未访问，等下次继续
        visited[i][j] = false;
        return false;
    }
}

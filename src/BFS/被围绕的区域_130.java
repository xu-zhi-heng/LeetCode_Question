package BFS;

import java.util.*;

public class 被围绕的区域_130 {
    static int m, n;
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'O','X','X','O','X'},
                {'X','O','O','X','O'},
                {'X','O','X','O','X'},
                {'O','X','O','O','O'},
                {'X','X','O','X','O'}
        };
        solve_02(board);
        print(board);
    }



    // 题目貌似解答有问题
    public static void solve_02(char[][] board) {
        n = board.length;
        m = board[0].length;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (board[i][j] == 'O') {
                    int xSize = 0;
                    int ySize = 0;
                    for (int k = 0; k < m; k++) {
                        if (board[i][k] == 'X') {
                            xSize++;
                        }
                        if (xSize >= 2) {
                            break;
                        }
                    }
                    for (int k = 0; k < n; k++) {
                        if (board[k][j] == 'X') {
                            ySize++;
                        }
                        if (ySize >= 2) {
                            break;
                        }
                    }
                    if (ySize >= 2 && xSize >= 2) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    public static void solve(char[][] board) {
        n = board.length;
        if (n == 0) {
            return;
        }
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m - 1);
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(board, 0, i);
            dfs(board, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }

    // bfs: 以边界O 为开始，如果 变为 O有一直相连的O，则肯定没有被包围
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void bfs(char[][] board) {
        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();

        // 将边缘的 O 变为 A, 并且记录该位置放入到queue中
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
                board[i][0] = 'A';
            }
            if (board[i][m - 1] == 'O') {
                queue.offer(new int[]{i, m - 1});
                board[i][m - 1] = 'A';
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new int[]{0, i});
                board[0][i] = 'A';
            }
            if (board[n - 1][i] == 'O') {
                queue.offer(new int[]{n - 1, i});
                board[n - 1][i] = 'A';
            }
        }

        // 根据边界A的位置，去搜索内部O的位置，如果搜索到O，就将该位置的变为A，并以此为基点，继续搜索
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                // 控制 x，y的位置，向上，下，左，右进行搜索
                int mx = x + dx[i], my = y + dy[i];
                // 如果超出边界，或者如果该元素是X，则停止下面的操作
                if (mx < 0 || my < 0 || mx >= n || my >= m || board[mx][my] != 'O') {
                    continue;
                }
                queue.offer(new int[]{mx, my});
                board[mx][my] = 'A';
            }
        }

        // 因为边界的A本来就是没有办法为包围的，所以只要是A就为O，否则就为X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }


    // Youtube: DFS
    public void solve_03(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;

        // 判断每一行的边界是否为 'O'
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                boundaryDFS(board, i, 0);
            }
            if (board[i][columns - 1] == 'O') {
                boundaryDFS(board, i, columns - 1);
            }
        }

        // 判断每一列的边界是否为 'O'
        for (int i = 0; i < columns; i++) {
            if (board[0][i] == 'O') {
                boundaryDFS(board, 0, i);
            }
            if (board[rows - 1][i] == 'O') {
                boundaryDFS(board, rows - 1, i);
            }
        }

        // 根据DFS的结果进行替换
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'A'){
                    board[i][j] = 'O';
                }
            }
        }

    }
    public void boundaryDFS(char[][] board, int i, int j) {
        if (i > board.length - 1 || j > board[0].length - 1 || i < 0 || j < 0) {
            return;
        }

        // 边界的 O 或者和边界 O 相连的部分都会进行标记
        if (board[i][j] == 'O') {
            board[i][j] = 'A';
        }

        // 遍历该位置的上下左右四个方向
        // 如果是和 O 相连的部分也是 O 那就 从新的地方子在进行遍历查询
        if (i < board.length - 1 && board[i + 1][j] == 'O') {
            boundaryDFS(board, i + 1, j);
        }
        if (i > 0 && board[i - 1][j] == 'O') {
            boundaryDFS(board, i - 1, j);
        }
        if (j > 0 && board[i][j - 1] == 'O') {
            boundaryDFS(board, i, j - 1);
        }
        if (j < board[0].length - 1 && board[i][j + 1] == 'O') {
            boundaryDFS(board, i, j + 1);
        }
    }


    public static void print(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

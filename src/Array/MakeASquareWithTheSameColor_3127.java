package Array;

public class MakeASquareWithTheSameColor_3127 {
    public boolean canMakeSquare(char[][] grid) {
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                int black = 0;
                int white = 0;
                if (grid[i][j] == 'B') {
                    black++;
                } else {
                    white++;
                }
                if (grid[i][j + 1] == 'B') {
                    black++;
                } else {
                    white++;
                }
                if (grid[i + 1][j] == 'B') {
                    black++;
                } else {
                    white++;
                }
                if (grid[i + 1][j + 1] == 'B') {
                    black++;
                } else {
                    white++;
                }
                if(black >= 3 || white >= 3) {
                    return true;
                }
            }
        }
        return false;
    }
}

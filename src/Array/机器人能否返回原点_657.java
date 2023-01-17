package Array;

public class 机器人能否返回原点_657 {
    public static void main(String[] args) {

    }

    public static boolean judgeCircle(String moves) {
        int len = moves.length();
        // 如果长度为奇数，那就是不可能返回
        if (len % 2 != 0) return false;
        int row = 0;
        int column = 0;
        for (int i = 0; i < len; i++) {
            switch (moves.charAt(i)) {
                case 'R': column++; break;
                case 'L': column--; break;
                case 'U': row--; break;
                case 'D': row++; break;
            }
        }
        return (row == 0 && column == 0);
    }
}

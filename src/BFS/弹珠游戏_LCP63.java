package BFS;

public class 弹珠游戏_LCP63 {
    public static void main(String[] args) {

    }

    public static int[][] ballGame(int num, String[] plate) {
        String[][] graph = new String[plate.length][];
        for (int i = 0; i < plate.length; i++) {
            for (int j = 0; j < plate[0].length(); j++) {
                graph[i][i] = String.valueOf(plate[i].charAt(j));
            }
        }
        return null;
    }
}

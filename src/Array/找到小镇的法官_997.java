package Array;

public class 找到小镇的法官_997 {
    public static void main(String[] args) {

    }

    public int findJudge(int n, int[][] trust) {
        int[] counts = new int[n + 1];

        for (int[] ints : trust) {
            // 你信任一个人就要 - 1， 别人信任你就要 + 1
            counts[ints[0]]--;
            counts[ints[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (counts[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}

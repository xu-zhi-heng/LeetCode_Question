package BitOperation;

public class 汉明距离_461 {
    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        System.out.println(hammingDistance(1,4));
    }
    public static int hammingDistance(int x, int y) {
        int result = x ^ y;
        return Integer.bitCount(result);
    }
}

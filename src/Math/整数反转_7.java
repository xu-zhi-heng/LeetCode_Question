package Math;

public class 整数反转_7 {
    public static void main(String[] args) {
        int x = -1534236469;
        long i = (long) x;
        long result = 0;
        while (i != 0) {
            result = result * 10 + i % 10;
            i = i / 10;
        }
        System.out.println(result > Integer.MIN_VALUE);
    }
}

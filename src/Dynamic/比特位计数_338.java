package Dynamic;

public class 比特位计数_338 {
    public static void main(String[] args) {

    }

    // Brian Kernighan 算法: 对于任意整数 xxx，令 x=x & (x−1)x=x~\&~(x-1)x=x & (x−1)，该运算将 xxx 的二进制表示的最后一个 111 变成 000。
    // 因此，对 xxx 重复该操作，直到 xxx 变成 000，则操作次数即为 xxx 的「一比特数」。
    public static int[] countBits_01(int n) {
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int ones = 0;
            int x = i;
            while (x > 0) {
                x = x & (x - 1);
                ones++;
            }
            arr[i - 1] = ones;
        }
        return arr;
    }
}

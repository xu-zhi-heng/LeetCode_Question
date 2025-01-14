package Dynamic;

public class MaximumNumberThatSumOfThePricesIsLessThanOrEqualToK_3007 {
    public static void main(String[] args) {

    }

    public static long findMaximumNumber(long k, int x) {
        long left = 1;
        long right = k;
        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            // 计算累加价值
            long totalValue = cumulativeValue(mid, x);

            if (totalValue <= k) {
                result = mid; // 更新结果为当前mid
                left = mid + 1; // 尝试更大的数字
            } else {
                right = mid - 1; // 尝试更小的数字
            }
        }

        return result;
    }
    public static long cumulativeValue(long num, int x) {
        long totalValue = 0;
        for (int i = 1; i <= num; i++) {
            totalValue += calculateValue(i, x);
        }
        return totalValue;
    }

    public static int calculateValue(int num, int x) {
        int value = 0;
        for (int i = x - 1; i < 32; i += x) {
            if (((num >> i) & 1) == 1) {
                value++;
            }
        }
        return value;
    }
}

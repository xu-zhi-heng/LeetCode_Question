package Array;

public class 最大连续1的个数_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }
        return max = Math.max(count, max);
    }
}

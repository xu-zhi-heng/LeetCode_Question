package Array;

public class NumOfZeroFilledSubArrays_2348 {
    public static void main(String[] args) {
        int[] nums = new int[100000];
        System.out.println(zeroFilledSubarray(nums));
    }
    public static long zeroFilledSubarray(int[] nums) {
        long result = 0L;
        long subZeroCount = 0L;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                subZeroCount++;
            } else {
                subZeroCount = 0L;
            }
            result += subZeroCount;
        }
        return result;
    }
}

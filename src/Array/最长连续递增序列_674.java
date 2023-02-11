package Array;

public class 最长连续递增序列_674 {
    public int findLengthOfLCIS(int[] nums) {
        int maxLen = 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                maxLen = Math.max(maxLen, i - j);
                j = i;
            }
        }

        return maxLen;
    }
}

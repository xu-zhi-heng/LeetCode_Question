package Array;

import java.util.Arrays;

public class 最短无序连续子数组_581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int start = nums.length;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != temp[i]) {
                start = Math.min(i, start);
                end = Math.max(end, i);
            }
        }
        if (end - start >= 0) {
            return end - start + 1;
        } else {
            return 0;
        }
    }
}

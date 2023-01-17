package Sort;

import java.util.Arrays;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 */
public class 丢失的数字_268 {
    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        missingNumber(arr);
    }

    public static int missingNumber(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            int minValue = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] < minValue) {
                    minIndex = j;
                    minValue = nums[j];
                }
            }
            if(minIndex != i) {
                nums[minIndex] = nums[i];
                nums[i] = minValue;
            }
        }

        System.out.println(Arrays.toString(nums));

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
}

package Array;

import java.util.Arrays;

public class 移除元素_27 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums, 2));
    }

    // 双指针
    public static int removeElement(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if(nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return left;
    }
}

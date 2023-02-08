package Array;
/**
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
 *
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 */
import java.util.ArrayList;
import java.util.List;
public class 数组中重复的数据_442 {
    public static void main(String[] args) {
        findDuplicates(new int[]{4,3,2,7,8,2,3,1});
    }
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> output_arr = new ArrayList<>();
        if (nums.length == 0) return output_arr;
        // 因为数据范围是 [1, n], 所以如果有一个数出现了两次，那么 [1, n] 就会有一个数没有出现过
        for (int i = 0; i < nums.length; i++) {
            // nums[i] 应该出现在 nums[i] - 1 的位置上
            while (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                output_arr.add(nums[i]);
            }
        }
        return output_arr;
    }

    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

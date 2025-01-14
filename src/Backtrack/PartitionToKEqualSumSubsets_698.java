package Backtrack;

import java.util.Arrays;
public class PartitionToKEqualSumSubsets_698 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1}; // 示例数组
        int k = 4; // 目标划分的子集数
        System.out.println(canPartitionKSubsets(nums, k));
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }

        int target = sum / k;
        Arrays.sort(nums);
        int n = nums.length;

        if (nums[n - 1] > target) {
            return false; // 最大的元素大于目标值，不可能划分成功
        }

        boolean[] used = new boolean[n];
        return search(nums, k, 0, 0, target, used);
    }

    public static boolean search(int[] nums, int k, int target, int curSum, int start, boolean[] visited) {
        if (k == 1) {
            return true;
        }
        if (curSum == target) {
            return search(nums, k - 1, target, 0, 0, visited);
        }

        for (int i = start; i < nums.length; i++) {
            if (!visited[i] && curSum + nums[i] <= target) {
                visited[i] = true;
                if (search(nums, k, target, curSum + nums[i], i + 1, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }

        return false;
    }

}

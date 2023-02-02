package Array;

import java.util.*;


public class 三数之和_15 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // i == 0的时候不需要考虑后面的清空，如果当前的元素和前一个元素是一样的，代表就是重复查找了
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = nums[i];
                while (low < high) {
                    sum = sum + nums[low] + nums[high];
                    if (sum == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[low]);
                        temp.add(nums[high]);
                        temp.add(nums[i]);
                        result.add(temp);
                        // 还是为了避免重复
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (sum > 0) {
                        high--;
                    } else {
                        low++;
                    }
                    sum = nums[i];
                }
            }
        }
        return result;
    }
}

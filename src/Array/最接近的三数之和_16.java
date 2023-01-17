package Array;

import java.util.Arrays;

public class 最接近的三数之和_16 {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }


    public static int threeSumClosest(int[] nums, int target) {
        // 枚举出所有的三数结果，然后进行比较
//        Arrays.sort(nums);
//        int minSize = Integer.MAX_VALUE;
//        int i = 0;
//        while (i + 3 <= nums.length) {
//            int j = i + 1;
//            int k = j + 1;
//            int sum = 0;
//            while (j <= nums.length - 1) {
//                k = j + 1;
//                while (k < nums.length) {
//                    sum = nums[i] + nums[j] + nums[k];
//                    if (sum == target) {
//                        return sum;
//                    }
//                    if (Math.abs(target - sum) < Math.abs(target - minSize)) {
//                        minSize = sum;
//                    }
//                    sum = 0;
//                    k++;
//                }
//                j++;
//            }
//            i++;
        // 错误部分，没有能够完全枚举出所有的情况
//            int right = left + 3;
//            int sum = 0;
//            List<Integer> visited = new ArrayList<>();
//            while (right <= nums.length) {
//                for (int i = left; i < right; i++) {
//                    if (!visited.contains(i)) {
//                        sum += nums[i];
//                    }
//                }
//                if (sum == target) {
//                    return sum;
//                }
//                if (Math.abs(target - sum) < Math.abs(target - minSize)) {
//                    minSize = sum;
//                }
//                visited.add(right - 1);
//                right++;
//                sum = 0;
//            }
//            visited.clear();
//            left++;
//        }
//        return minSize;

        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int a_pointer = i + 1;
            int b_pointer = nums.length - 1;
            while (a_pointer < b_pointer) {
                int current_sum = nums[i] + nums[a_pointer] + nums[b_pointer];
                if (current_sum > target) {
                    b_pointer = b_pointer - 1;
                } else {
                    a_pointer += 1;
                }
                // 比较
                if (Math.abs(current_sum - target) < Math.abs(result - target)) {
                    result = current_sum;
                }
            }
        }
        return result;
    }
}

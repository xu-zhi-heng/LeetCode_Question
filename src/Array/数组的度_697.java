package Array;

import java.util.HashMap;

/**
 * 给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 */
public class 数组的度_697 {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        HashMap<Integer, Integer> firstSeen = new HashMap<>();
        int degree = 0;
        int minLen = 0;
        for (int i = 0; i < nums.length; i++) {
            // 先判断指定的键（key）是否存在，不存在则将键/值对插入到 HashMap 中。
            firstSeen.putIfAbsent(nums[i], i);
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
            if (counts.get(nums[i]) > degree) {
                degree = counts.get(nums[i]);
                minLen = i - firstSeen.get(nums[i]) + 1;
            }
            if (counts.get(nums[i]) == degree) {
                minLen = Math.min(minLen, i - firstSeen.get(nums[i]) + 1);
            }
        }
        return minLen;
    }
}

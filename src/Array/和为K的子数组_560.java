package Array;

import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 */
public class 和为K的子数组_560 {
    // 在从头到尾逐个扫描数组中的数字时求出前i个数字之和，并且将和保存下来。数组的前i个数字之和记为x。
    // 如果存在一个j(j<i),数组的前j个数字之和为x-k,那么数组中从j+1个数字开始到第i个数字结束的子数组之和为k
    // x - k + k = x
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // 和为0的出现了1次
        hashMap.put(0, 1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];

            // 判断是否出现了 x - k
            if (hashMap.containsKey(sum - k)) {
                ans += hashMap.get(sum - k);
            }

            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}

package PrefixSum;

import java.util.HashMap;

public class 使数组和能被P整除_1590 {
    public int minSubarray(int[] nums, int p) {
        int ans = nums.length;
        // 前缀和数组
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = (prefixSum[i] + nums[i]) % p;
        }
        // 如果最后一个元素为0，代表整个数组的前缀和求余p是可以的
        int x = prefixSum[ans];
        if (x == 0) {
            return 0;
        }
        HashMap<Integer, Integer> last = new HashMap<>();
        for (int i = 0; i < prefixSum.length; i++) {
            last.put(prefixSum[i], i);
            // (prefixSum[i] - x + p) % p: x为最后一个元素，x - prefixSum[i]: 代表这一段子数组的元素和
            int j = last.getOrDefault((prefixSum[i] - x + p) % p, -nums.length);
            ans = Math.min(ans, i - j);
        }
        if (ans < nums.length) {
            return ans;
        } else {
            return -1;
        }
    }
}

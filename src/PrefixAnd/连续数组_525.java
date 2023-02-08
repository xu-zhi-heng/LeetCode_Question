package PrefixAnd;

import java.util.HashMap;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 */
public class 连续数组_525 {
    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        int counter = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(counter, -1);
        for (int i = 0; i < nums.length; i++) {
            // 将问题变为，找前缀和为 0， 等于 0 说明前面的元素 0 和 1 的数量是相等的
            if (nums[i] == 0) {
                counter = counter - 1;
            } else {
                counter = counter + 1;
            }
            // 如果之前有过这个元素，然后再到后面再看见了这个元素，那么说明这段距离中的元素和等于 0
            if (hashMap.containsKey(counter)) {
                maxLen = Math.max(maxLen, i - hashMap.get(counter));
            } else {
                hashMap.put(counter, i);
            }
        }
        return maxLen;
    }
}

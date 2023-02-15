package Array;

import java.util.HashSet;

public class 最长连续序列_128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        int longResult = 0;

        for (int num : hashSet) {
            // 如果存在 num - 1 就跳过的原因是因为，我们要找最长的，那么 num - 1, num 这样才是最长的，意思就是找最开始的起点
            if (!hashSet.contains(num - 1)) {
                int currentNum = num;
                int len = 1;

                while (hashSet.contains(currentNum + 1)) {
                    currentNum = currentNum + 1;
                    len++;
                }

                longResult = Math.max(longResult, len);
            }
        }

        return longResult;
    }
}

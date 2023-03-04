package BitOperation;

import java.util.HashMap;

/**
 * 给你一个整数数组 nums ，返回其中 按位与三元组 的数目。
 *
 * 按位与三元组 是由下标 (i, j, k) 组成的三元组，并满足下述全部条件：
 *
 * 0 <= i < nums.length
 * 0 <= j < nums.length
 * 0 <= k < nums.length
 * nums[i] & nums[j] & nums[k] == 0 ，其中 & 表示按位与运算符。
 */
public class 按位与为零的三元组_982 {
    public static void main(String[] args) {
        System.out.println(countTriplets(new int[]{0, 0, 0}));
    }
    // 初始枚举需要 3 层 循环， O(n^3)
    // 可以先枚举前两个，然后枚举最后一个
    public static int countTriplets(int[] nums) {
        int len = nums.length;
        int ans = 0;
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int a = nums[i] & nums[j];
                if (counts.containsKey(a)) {
                    counts.put(a, counts.get(a) + 1);
                } else {
                    counts.put(a, 1);
                }
            }
        }

        for (int k = 0; k < len; k++) {
            for (int num = 0; num < 1 << 16; num++) {
                if ((nums[k] & num) == 0) {
                    if (counts.containsKey(num)) {
                        ans += counts.get(num);
                    }
                }
            }
        }
        return ans;
    }
}

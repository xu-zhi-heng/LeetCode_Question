package Dynamic;

import java.util.HashMap;

public class 跳跃游戏_55 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 0};
        System.out.println(backTrack(nums, 0, new HashMap<Integer, Boolean>()));
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        // dp[i]代表第i个位置可以到达的最大位置
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(i + nums[i], dp[i - 1]);
            if (dp[i] >= nums.length -1) {
                return true;
            }
            // 代表已经无法向前移动了
            if (dp[i] == i) {
                return false;
            }
        }
        return false;
    }

    // DFS递归 + 记忆化搜索，nums[i]能到达的位置全部试一遍
    public static boolean backTrack(int[] nums, int index, HashMap<Integer, Boolean> memory) {
        if (memory.containsKey(index)) {
            return memory.get(index);
        }
        if (index >= nums.length - 1) {
            return true;
        }
        for (int i = 1; i <= nums[index]; i++) {
            if (backTrack(nums, index + i, memory)) {
                memory.put(index + i, true);
                return true;
            }
        }
        memory.put(index, false);
        return false;
    }
}

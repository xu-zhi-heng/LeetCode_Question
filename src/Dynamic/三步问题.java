package Dynamic;

import java.util.HashMap;

public class 三步问题 {
    public static void main(String[] args) {
        System.out.println(waysToStep(61));
    }

    public static int waysToStep(int n) {
        return dfs(n, new int[]{1, 2, 3}, new HashMap<>());
    }

    public static int dfs(int target, int[] nums, HashMap<Integer, Integer> memory) {
        if (memory.containsKey(target)) return memory.get(target);
        if (target < 0) return 0;
        if (target == 0) return 1;
        int total = 0;

        for (int num : nums) {
            int count = dfs(target - num, nums, memory);
            total = (total + count) % 1000000007;
        }
        memory.put(target, total);
        return total;
    }
}

package Backtrack;

import java.util.ArrayList;
import java.util.List;

public class 全排列_46 {
    public static void main(String[] args) {
        permute(new int[]{1,2,3});
    }
    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[len];
        int count = 0;
        backTrace(list, used, count, nums);
        return result;
    }

    public static void backTrace(List<Integer> list, boolean[] used, int count, int[] nums) {
        // 如果count和数组长度相等，那么代表数添完了
        if (count == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                backTrace(list, used, count + 1, nums);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
}

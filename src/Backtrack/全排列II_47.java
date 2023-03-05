package Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列II_47 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        boolean[] visited = new boolean[len];
        List<Integer> list = new ArrayList<>();
        int count = 0;

        Arrays.sort(nums);

        backTrack(list, visited, count, nums);

        return result;
    }

    public void backTrack(List<Integer> list, boolean[] visited, int count, int[] nums) {
        if (count == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                backTrack(list, visited, count + 1, nums);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}

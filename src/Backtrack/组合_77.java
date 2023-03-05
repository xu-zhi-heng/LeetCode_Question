package Backtrack;
import java.util.ArrayList;
import java.util.List;
public class 组合_77 {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        int count = 0;
        boolean[] visited = new boolean[n];
        List<Integer> list = new ArrayList<>();
        backTrack(list, count, visited, nums, k, 0);
        return result;
    }

    public static void backTrack(List<Integer> list, int count, boolean[] visited, int[] nums, int len, int begin) {
        if (count == len) {
            result.add(new ArrayList<>(list));
            return;
        }
        // 这边进行剪枝操作， 比如： n = 7, k = 4, 当从第五个数开始时，根本凑不齐 4 个数的组合，所以不需要再进行回溯
        for (int i = begin; i < nums.length - (len - list.size()) + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                backTrack(list, count + 1, visited, nums, len, i + 1);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}

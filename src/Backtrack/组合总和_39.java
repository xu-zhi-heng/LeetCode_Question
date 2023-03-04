package Backtrack;
import javax.swing.text.View;
import java.util.*;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class 组合总和_39 {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{3,12,9,11,6,7,8,5,4}, 15));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = DFS(candidates, target, new HashMap<>());
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            Collections.sort(result.get(i));
            if (!ans.contains(result.get(i))) {
                ans.add(result.get(i));
            }
        }
        return ans;
    }

    public static List<List<Integer>> DFS(int[] candidates, int target, HashMap<Integer, List<List<Integer>>> memory) {
        if (memory.containsKey(target)) {
            return memory.get(target);
        }
        if (target == 0) {
            return new ArrayList<>(Arrays.asList(new ArrayList<>()));
        }
        if (target < 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int candidate : candidates) {
            if (target - candidate >= 0) {
                int restNum = target - candidate;
                List<List<Integer>> suffixWays = DFS(candidates, restNum, memory);
                List<List<Integer>> targetWays = new ArrayList<>();
                for (List<Integer> suffixWay : suffixWays) {
                    List<Integer> temp = new ArrayList<>(suffixWay);
                    temp.add(candidate);
                    targetWays.add(temp);
                }
                result.addAll(targetWays);
            }
        }
        memory.put(target, result);
        return result;
    }
}

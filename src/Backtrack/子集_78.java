package Backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class 子集_78 {
    public static void main(String[] args) {
        System.out.println(subsets_02(new int[]{1, 2, 3}));
    }

    // 回溯
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> t = new ArrayList<Integer>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return result;
    }
    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            result.add(new ArrayList<Integer>(t));
            return;
        }
        // 当前的位置选
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        // 当前的位置不选
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }


    // 迭代法, 数组的长度是多少，可以用真值表的方式，0和1代替，0表示在，1表示不在，这样就可以枚举出所有情况
    public static List<List<Integer>> subsets_02(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 有多少中组合
        int len = (int) (Math.pow(2, nums.length));
        for (int i = 0; i < len; i++) {
            // 求出对应整数的二进制表达方式， len 位
            StringBuilder stringBuilder = new StringBuilder();
            int num = i;
            stringBuilder.append(num % 2);
            num /= 2;
            while (num != 0) {
                stringBuilder.insert(0, num % 2);
                num = num / 2;
            }
            // 位数不够时，向前添加 0
            while (stringBuilder.length() < nums.length) {
                stringBuilder.insert(0, 0);
            }
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (stringBuilder.charAt(j) == '1') {
                    list.add(nums[j]);
                }
            }
            result.add(list);
        }
        return result;
    }
}

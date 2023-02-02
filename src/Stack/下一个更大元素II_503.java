package Stack;

import java.util.Arrays;
import java.util.Stack;

public class 下一个更大元素II_503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len * 2; i++) {
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek()]) {
                ans[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }
        return ans;
    }
}

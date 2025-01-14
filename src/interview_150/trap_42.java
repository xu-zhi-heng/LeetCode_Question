package interview_150;

import java.util.Stack;

public class trap_42 {

    public static void main(String[] args) {
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }


    public static int trap(int[] height) {
        // 单调栈, 纵向计算
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (height[stack.peek()] >= height[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int first = stack.peek();
                        int h = Math.min(height[i], height[first]) - height[mid];
                        int w = i - first - 1;
                        ans += h * w;
                    }
                }
                stack.push(i);
            }
        }
        return ans;
    }
}

package Stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 *
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 */
public class 行星碰撞_735 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{1,-2,-2,-2})));
    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        int index = 1;
        // 1,-2,-2,-2
        while (index < asteroids.length) {
            if (!stack.isEmpty() && stack.peek() > 0 && asteroids[index] < 0) {
                if (Math.abs(stack.peek()) == Math.abs(asteroids[index])) {
                    stack.pop();
                    index++;
                    continue;
                }
                if (Math.abs(stack.peek()) > Math.abs(asteroids[index])) {
                    index++;
                    continue;
                }
                if (Math.abs(stack.peek()) < Math.abs(asteroids[index])) {
                    stack.pop();
                }
            } else {
                stack.push(asteroids[index]);
                index++;
            }
        }


        int[] output_arr = new int[stack.size()];
        int lastIndex = stack.size() - 1;
        while (!stack.isEmpty()) {
            output_arr[lastIndex] = stack.pop();
            lastIndex--;
        }
        return output_arr;
    }
}

package String;

import java.util.Stack;

/**
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 */
public class 移掉K位数字_402 {
    public static void main(String[] args) {

    }
    public String removeKdigits(String num, int k) {
        int size = num.length();
        if (size == k) return "0";

        Stack<Character> stack = new Stack<>();

        int counter = 0;
        while (counter < size) {
            // 贪心： 对于一个相等长度的数来说，前面的数 值越小，整个数值也就最小
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(counter)) {
                stack.pop();
                k--;
            }

            stack.push(num.charAt(counter));
            counter++;
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        stringBuilder.reverse();

        while (stringBuilder.length() > 1 && stringBuilder.charAt(0) == '0') {
            stringBuilder.deleteCharAt(0);
        }

        return stringBuilder.toString();
    }
}

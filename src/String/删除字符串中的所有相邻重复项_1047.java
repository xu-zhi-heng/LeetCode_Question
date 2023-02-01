package String;

import java.util.Stack;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 */
public class 删除字符串中的所有相邻重复项_1047 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        int index = 1;
        while (index < s.length()) {
            if (!stack.isEmpty()) {
                if (stack.peek() == s.charAt(index)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(index));
                }
            } else {
                stack.push(s.charAt(index));
            }
            index++;
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}

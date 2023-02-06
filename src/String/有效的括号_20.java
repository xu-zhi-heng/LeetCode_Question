package String;

import java.util.Arrays;
import java.util.Stack;

public class 有效的括号_20 {
    public static void main(String[] args) {
        boolean valid = isValid("([}}])");
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        if(s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (!stack.isEmpty() && s.charAt(i) == ')' && stack.peek() == '('){
                stack.pop();
            } else if (!stack.isEmpty() && s.charAt(i) == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (!stack.isEmpty() && s.charAt(i) == '}' && stack.peek() == '{') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}

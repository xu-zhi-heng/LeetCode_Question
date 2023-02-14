package Stack;

import java.util.Stack;

public class 移除无效的括号_1249 {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
    }
    public static String minRemoveToMakeValid(String s) {
        if (s.length() == 0) {
            return s;
        }
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int leftCounts = 0;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                stack.push(s.charAt(i) + "");
            }
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i) + "");
                leftCounts++;
            }
            if (s.charAt(i) == ')' && leftCounts > 0) {
                stack.push(s.charAt(i) + "");
                leftCounts--;
            }
        }
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            if (pop.equals("(")) {
                if (leftCounts <= 0) {
                    result.append(pop);
                } else {
                    leftCounts--;
                }
            } else {
                result.append(pop);
            }
        }

        return result.reverse().toString();
    }
}

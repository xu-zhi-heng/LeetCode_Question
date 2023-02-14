package Stack;

import java.util.Stack;

public class 括号的分数_856 {
    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("(())"));
    }
    public static int scoreOfParentheses(String s) {
        if (s.equals("")) {
            return 0;
        }
        int index = 0;
        Stack<String> stack = new Stack<>();

        while (index < s.length()) {
            if (s.charAt(index) != ')') {
                stack.push(s.charAt(index) + "");
            } else {
                int sum = 0;
                while (!stack.isEmpty()) {
                    String pop = stack.pop();
                    if (pop.equals("(")) {
                        if (sum == 0) {
                            stack.push("1");
                        } else {
                            stack.push(2 * sum + "");
                        }
                        break;
                    } else {
                        sum += Integer.parseInt(pop);
                    }
                }
            }
            index++;
        }
        int score = 0;
        while (!stack.isEmpty()) {
            score += Integer.parseInt(stack.pop());
        }
        return score;
    }
}

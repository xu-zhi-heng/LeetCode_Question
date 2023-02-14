package Backtrack;

import java.util.ArrayList;
import java.util.List;

public class 括号生成_22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        backTrack(result, "", n, 0, 0);
        return result;
    }

    public void backTrack(List<String> result, String current, int max, int open, int close) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        if (open < max) {
            backTrack(result, current + "(", max, open + 1, close);
        }
        if (close < open) {
            backTrack(result, current + ")", max, open, close + 1);
        }
    }
}

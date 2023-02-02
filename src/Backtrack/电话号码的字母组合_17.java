package Backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class 电话号码的字母组合_17 {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> queue = new LinkedList<>();
        if (digits.length() == 0) {
            return queue;
        }
        queue.add("");
        String[] char_mao = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tvu", "wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            int index = Character.getNumericValue(digits.charAt(i));
            // digits的长度多长，说明最后排列后的每一个字符有多长
            while (queue.peek().length() == i) {
                // 利用队列，从头取出，进行合并再放入的尾部
                String temp = queue.poll();
                for (char c : char_mao[index].toCharArray()) {
                    queue.add(temp + c);
                }
            }
        }
        return queue;
    }
}

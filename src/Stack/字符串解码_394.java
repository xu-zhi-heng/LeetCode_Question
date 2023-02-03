package Stack;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */
public class 字符串解码_394 {
    public String decodeString(String s) {
        if (s.length() == 0) return "";
        Stack<Integer> number = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int i;
        for (i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                StringBuilder num = new StringBuilder();
                num.append(s.charAt(i));
                while (Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    num.append(s.charAt(i));
                }
                number.push(Integer.parseInt(String.valueOf(num)));
            } else if (Character.isLetter(s.charAt(i)) || String.valueOf(s.charAt(i)).equals("[")) {
                stringStack.push(String.valueOf(s.charAt(i)));
            } else {
                StringBuilder temp = new StringBuilder();
                while (!stringStack.peek().equals("[")) {
                    temp.append(stringStack.pop());
                }
                temp = temp.reverse();
                stringStack.pop();
                int count = 0;
                if (!number.isEmpty()) {
                    count = number.pop();
                    String str = temp.toString();
                    for (int j = 0; j < count - 1; j++) {
                        temp.append(str);
                    }
                }
                for (int k = 0; k < temp.length(); k++) {
                    stringStack.push(temp.charAt(k) + "");
                }
            }
        }
        while (!stringStack.isEmpty()) {
            result.append(stringStack.pop());
        }
        return result.reverse().toString();
    }
}

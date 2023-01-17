package String;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个由小写字母组成的字符串 s ，以及一个整数 k 。
 *
 * 首先，用字母在字母表中的位置替换该字母，将 s 转化 为一个整数（也就是，'a' 用 1 替换，'b' 用 2 替换，... 'z' 用 26 替换）。
 * 接着，将整数 转换 为其 各位数字之和 。共重复 转换 操作 k 次 。
 *
 * 例如，如果 s = "zbax" 且 k = 2 ，那么执行下述步骤后得到的结果是整数 8 ：
 *
 * 转化："zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
 * 转换 #1：262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
 * 转换 #2：17 ➝ 1 + 7 ➝ 8
 * 返回执行上述操作后得到的结果整数。
 */
public class 字符串转化后的各位数字之和_1945 {
    public static void main(String[] args) {
        System.out.println(getLucky("iiii", 1));
    }

    public static int getLucky(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i) - 96);
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = 0;
            for (int j = 0; j < stringBuilder.length(); j++) {
                res += Integer.parseInt(String.valueOf(stringBuilder.charAt(j)));
            }
            String temp = String.valueOf(res);
            stringBuilder.delete(0, stringBuilder.length());
            for (int g = 0; g < temp.length(); g++) {
                stringBuilder.append(temp.charAt(g));
            }
        }
        return res;
    }
}

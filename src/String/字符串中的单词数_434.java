package String;

import java.util.Arrays;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 */
public class 字符串中的单词数_434 {
    public static void main(String[] args) {
        countSegments(", , , ,        a, eaefa");
    }
    public static int countSegments(String s) {
        if (s.length() == 0) return 0;
        int count = 0;
        for (int i = 0; i < s.split(" ").length; i++) {
            if (!s.split(" ")[i].equals("")) {
                count++;
            }
        }
        return count;
    }
}

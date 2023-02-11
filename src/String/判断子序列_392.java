package String;
/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 */
public class 判断子序列_392 {
    public boolean isSubsequence(String s, String t) {
        int s_pointer = 0;
        int t_pointer = 0;
        while (s_pointer < s.length() && t_pointer < t.length()) {
            if (s.charAt(s_pointer) == t.charAt(t_pointer)) {
                s_pointer++;
                t_pointer++;
            } else {
                t_pointer++;
            }
        }
        return s_pointer == s.length();
    }
}

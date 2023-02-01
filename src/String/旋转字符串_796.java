package String;

/**
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 *
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
 *
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 */
public class 旋转字符串_796 {
    public static void main(String[] args) {
        rotateString("abcde", "cdeab");
    }
    public static boolean rotateString(String s, String goal) {
        // 找到goal的首字母在s中出现的位置
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == goal.charAt(0)) {
                StringBuilder temp = new StringBuilder(s);
                for (int j = 0; j < i; j++) {
                    temp.append(temp.charAt(0));
                    temp.deleteCharAt(0);
                }
                if (goal.equals(String.valueOf(temp))) {
                    return true;
                }
            }
        }
        return false;
    }
}

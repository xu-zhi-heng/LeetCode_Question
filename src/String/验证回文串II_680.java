package String;

/**
 * 给你一个字符串 s，最多 可以从中删除一个字符。
 *
 * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
 */
public class 验证回文串II_680 {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // 当出现字符不同的时候，分两种，第一种删除前面的，第二种删除后面的，分别删除完后的字符是否还是回文字符
                return (helperMethod(s, left + 1, right) || helperMethod(s, left, right - 1));
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean helperMethod(String s, int i, int j) {
        int left = i;
        int right = j;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

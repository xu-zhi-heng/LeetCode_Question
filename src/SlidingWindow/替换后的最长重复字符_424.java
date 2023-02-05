package SlidingWindow;
/**
 * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
 *
 * 在执行上述操作后，返回包含相同字母的最长子字符串的长度。
 */
public class 替换后的最长重复字符_424 {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] char_count = new int[26];
        int window_start = 0;
        int max_len = 0;
        int max_count = 0;
        for (int window_end = 0; window_end < len; window_end++) {
            char_count[s.charAt(window_end) - 'A']++;
            int current_char_count = char_count[s.charAt(window_end) - 'A'];
            max_count = Math.max(max_count, current_char_count);
            // window_end - window_start + 1 ： 代表这一段有多少个字符，如果window_end - window_start + 1 都没有 k 大，那么都可以替换成同样的
            // window_end - window_start - max_count + 1意味着，这一段字符串中，我们肯定要取字符串最多的那一字串，那么剩下的就是不同的，如果不同的比 k 还大
            // 那么说明这种情况是不可行的
            while (window_end - window_start - max_count + 1 > k) {
                char_count[s.charAt(window_start) - 'A']--;
                window_start++;
            }
            max_len = Math.max(max_len, window_end - window_start + 1);
        }
        return max_len;
    }
}

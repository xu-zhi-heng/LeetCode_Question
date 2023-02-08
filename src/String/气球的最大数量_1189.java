package String;

/**
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 *
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 */
public class 气球的最大数量_1189 {
    public int maxNumberOfBalloons(String text) {
        int[] char_counts = new int[26];
        int ans = 0;
        String balloon = "balloon";
        for (int i = 0; i < text.length(); i++) {
            char_counts[text.charAt(i) - 'a']++;
        }
        while (true) {
            for (int i = 0; i < balloon.length(); i++) {
                if (char_counts[balloon.charAt(i) - 'a'] <= 0) {
                    return ans;
                } else {
                    char_counts[balloon.charAt(i) - 'a']--;
                }
            }
            ans++;
        }
    }
}

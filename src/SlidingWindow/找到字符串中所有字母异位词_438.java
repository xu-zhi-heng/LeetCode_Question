package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 找到字符串中所有字母异位词_438 {
    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int pLen = p.length();
        int sLen = s.length();

        if (sLen < pLen) {
            return result;
        }

        int[] s_counts = new int[26];
        int[] p_counts = new int[26];

        // 先统计前 pLen 个 字符出现的次数
        for (int i = 0; i < pLen; i++) {
            s_counts[s.charAt(i) - 'a']++;
            p_counts[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(s_counts, p_counts)) {
            result.add(0);
        }

        for (int i = 0; i < sLen - pLen; i++) {
            // 去掉前面的一个字符，然后加上后面的一个
            s_counts[s.charAt(i) - 'a']--;
            s_counts[s.charAt(i + pLen) -'a']++;
            if (Arrays.equals(s_counts, p_counts)) {
                result.add(i + 1);
            }
        }

        return result;
    }
}

package String;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你两个字符串数组 words1 和 words2。
 *
 * 现在，如果 b 中的每个字母都出现在 a 中，包括重复出现的字母，那么称字符串 b 是字符串 a 的 子集 。
 *
 * 例如，"wrr" 是 "warrior" 的子集，但不是 "world" 的子集。
 * 如果对 words2 中的每一个单词 b，b 都是 a 的子集，那么我们称 words1 中的单词 a 是 通用单词 。
 *
 * 以数组形式返回 words1 中所有的通用单词。你可以按 任意顺序 返回答案。
 */
public class 单词子集_916 {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        if (words1.length == 0 || words2.length == 0) return result;

        // 统计words2中每个字符出现的最大频率是多少
        int[] max_char = new int[26];
        for (String word2 : words2) {
            int[] word2_char = new int[26];
            for (int i = 0; i < word2.length(); i++) {
                word2_char[word2.charAt(i) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                max_char[j] = Math.max(max_char[j], word2_char[j]);
            }
        }

        for (String word1 : words1) {
            int[] word1_char = new int[26];
            boolean flag = true;
            // 统计每一个word1中字符出现的次数
            for (int i = 0; i < word1.length(); i++) {
                word1_char[word1.charAt(i) - 'a']++;
            }
            // 和words2中出现最大频率进行比较，如果小，则不满足
            for (int j = 0; j < 26; j++) {
                if (word1_char[j] < max_char[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(word1);
            }
        }
        return result;
    }
}

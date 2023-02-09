package String;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。
 *
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 */
public class 词典中最长的单词_720 {
    public static void main(String[] args) {
        String[] words = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));
    }
    public static String longestWord(String[] words) {
        Arrays.sort(words);
        HashSet<String> hashSet = new HashSet<>();
        String result = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 1 || hashSet.contains(words[i].substring(0, words[i].length() - 1))) {
                if (words[i].length() > result.length()) {
                    result = words[i];
                }
                hashSet.add(words[i]);
            }
        }
        return result;
    }
}

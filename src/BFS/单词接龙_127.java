package BFS;
import java.util.*;

/**
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 * 每一对相邻的单词只差一个字母。
 *  对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，
 * 返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 */
public class 单词接龙_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        if (!set.contains(endWord)) return 0;

        int count = 1;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current_word = queue.poll();
                char[] char_arr = current_word.toCharArray();
                for (int j = 0; j < char_arr.length; j++){
                    char origin_char = char_arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (origin_char != c) {
                            char_arr[j] = c;
                            String word = String.valueOf(char_arr);
                            if (word.equals(endWord)) {
                                return count + 1;
                            }
                            if (set.contains(word)) {
                                queue.offer(word);
                                set.remove(word);
                            }
                        }
                    }
                    char_arr[j] = origin_char;
                }
            }
            count++;
        }
        return 0;
    }
}

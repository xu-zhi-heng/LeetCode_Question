package interview_150;

import java.util.*;

public class findSubstring_30 {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word","good","best","good"};
        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordsLength = words.length;
        int wordLength = words[0].length();
        int sLength = s.length();

        for (int i = 0; i < wordLength && (i + wordLength * wordsLength) <= sLength; i++) {
            Map<String, Integer> countMap = new HashMap<>();
            for (int j = 0; j < wordsLength; j++) {
                String word = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                countMap.put(word, countMap.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                countMap.put(word, countMap.getOrDefault(word, 0) - 1);
                if (countMap.get(word) == 0) {
                    countMap.remove(word);
                }
            }
            if (countMap.isEmpty()) {
                result.add(i);
            }
            // 开始滑动窗口
            int left = i;
            int right = i + (wordLength * wordsLength);
            while (right + wordLength <= sLength) {
                String removeWord = s.substring(left, left + wordLength);
                String joinWord = s.substring(right, right + wordLength);

                countMap.put(removeWord, countMap.getOrDefault(removeWord, 0) - 1);
                if (countMap.get(removeWord) == 0) {
                    countMap.remove(removeWord);
                }
                countMap.put(joinWord, countMap.getOrDefault(joinWord, 0) + 1);
                if (countMap.get(joinWord) == 0) {
                    countMap.remove(joinWord);
                }
                left = left + wordLength;
                right = right + wordLength;
                if (countMap.isEmpty()) {
                    result.add(left);
                }
            }
        }

        return result;
    }


}

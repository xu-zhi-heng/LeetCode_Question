package String;

import java.util.HashMap;
import java.util.Map;

public class 情感丰富的文字_809 {
    public static void main(String[] args) {
        String[] words = {"le"};
        System.out.println(expressiveWords_02("lee", words));

    }


    public static int expressiveWords(String s, String[] words) {
        int sum = 0;

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String key = s.charAt(i) + "";
            if (!hashMap.containsKey(key)) {
                hashMap.put(key, 1);
            } else {
                hashMap.put(key, hashMap.get(key) + 1);
            }
        }
        System.out.println(hashMap);

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            HashMap<String, Integer> wordMap = new HashMap<>();
            for (int j = 0; j < word.length(); j++) {
                if (!hashMap.containsKey(word.charAt(j) + "")) {
                    wordMap.clear();
                    break;
                }
                if (!wordMap.containsKey(word.charAt(j) + "")) {
                    wordMap.put(word.charAt(j) + "", 1);
                } else {
                    wordMap.put(word.charAt(j) + "", wordMap.get(word.charAt(j) + "") + 1);
                }
            }
            if (wordMap.size() == hashMap.size()) {
                System.out.println(wordMap);
                boolean flag = true;
                for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                    if (entry.getValue() == wordMap.get(entry.getKey())) {
                        continue;
                    } else if (entry.getValue() < wordMap.get(entry.getKey())){
                        flag = false;
                        break;
                    } else {
                        Integer num = entry.getValue() - wordMap.get(entry.getKey());
                        if (num + wordMap.get(entry.getKey()) < 3) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static int expressiveWords_02(String s, String[] words) {
        int sum = 0;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            int wordPoint = 0;
            int sPoint = 0;

            if (word.length() > s.length()) {
                continue;
            }

            while (wordPoint < word.length() && sPoint < s.length()) {
                if (s.charAt(sPoint) != word.charAt(wordPoint)) {
                    break;
                }
                char ch = s.charAt(sPoint);

                int length1 = 0;
                while (sPoint < s.length() && s.charAt(sPoint) == ch) {
                    length1++;
                    sPoint++;
                }

                int length2 = 0;
                while (wordPoint < word.length() && word.charAt(wordPoint) == ch) {
                    length2++;
                    wordPoint++;
                }

                if (length2 > length1) {
                    break;
                }

                if (length2 != length1 && length1 < 3) {
                    break;
                }

                if (wordPoint == word.length() && sPoint == s.length() ) {
                    sum++;
                }
            }
        }

        return sum;
    }
}

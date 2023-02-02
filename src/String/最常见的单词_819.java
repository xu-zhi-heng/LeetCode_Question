package String;

import java.util.*;

public class 最常见的单词_819 {
    public static void main(String[] args) {
        System.out.println(mostCommonWord("..Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }
    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        String[] arr = paragraph.split(" ");
        List<String> list = new ArrayList<>();
        for (String value : banned) {
            list.add(value);
        }
        HashMap<String, Integer> hashMap = new HashMap<>();

        StringBuilder str = new StringBuilder();
        for (String s : arr) {
            str = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (Character.isLetter(c)) {
                    str.append(c);
                } else {
                    if (!list.contains(str.toString()) && str.length() != 0) {
                        hashMap.put(str.toString(), hashMap.getOrDefault(str.toString(), 0) + 1);
                    }
                    str.setLength(0);
                }
            }
            if (str.length() != 0) {
                if (!list.contains(str.toString())) {
                    hashMap.put(str.toString(), hashMap.getOrDefault(str.toString(), 0) + 1);
                }
            }
        }


        String result = null;
        int max = 0;
        for (Map.Entry<String,Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}

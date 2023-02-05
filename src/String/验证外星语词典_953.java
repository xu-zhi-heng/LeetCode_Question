package String;

import java.util.HashMap;

/**
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 *
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 */
public class 验证外星语词典_953 {
    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
    }
    public static boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            hashMap.put(order.charAt(i), i + 1);
        }
        hashMap.put('∅', 0);
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            int index = 0;
            while (index < word1.length() || index < word2.length()) {
                char a = index == word1.length() ? '∅' : word1.charAt(index);
                char b = index == word2.length() ? '∅' : word2.charAt(index);
                if (a == b) {
                    index++;
                } else {
                    if (hashMap.get(a) < hashMap.get(b)) {
                        break;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

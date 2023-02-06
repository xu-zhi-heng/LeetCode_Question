package String;

import java.util.HashMap;

/**
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 */
public class 单词规律_290 {
    public static void main(String[] args) {
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
    }
    public static boolean wordPattern(String pattern, String s) {
        if (pattern.length() != s.split(" ").length) return false;
        String[] arr = s.split(" ");
        HashMap<Character, String> hashMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!hashMap.containsKey(pattern.charAt(i))) {
                if (hashMap.containsValue(arr[i])) {
                    return false;
                } else {
                    hashMap.put(pattern.charAt(i), arr[i]);
                }
            } else {
                if (!hashMap.get(pattern.charAt(i)).equals(arr[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}

package String;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class 无重复字符的最长子串_3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    // 使用的方式和第1781题的思路是一样的，遍历每一个字串，往list中添加元素，如果这个元素存在，就终止内循环并比较大小
    public static int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        }
        int maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            List<Character> list = new ArrayList<>();
            for (int j = i; j < s.length(); j++) {
                if (list.contains(s.charAt(j))) {
                    if (list.size() > maxLen) {
                        maxLen = list.size();
                    }
                    break;
                }
                list.add(s.charAt(j));
            }
            if (list.size() > maxLen) {
                maxLen = list.size();
            }
        }
        return maxLen;
    }
}

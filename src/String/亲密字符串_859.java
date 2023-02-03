package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
 *
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 *
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 */
public class 亲密字符串_859 {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        // 如果两个字符是相同的，判断他们是否有重复元素，如果有，那么交换那两个一样的元素也是可以的
        if (s.equals(goal)) {
            HashSet<Character> hashSet = new HashSet<>();
            for (char c : s.toCharArray()) {
                hashSet.add(c);
            }
            if (hashSet.size() < s.length()) {
                return true;
            } else {
                return false;
            }
        }
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diff.add(i);
            }
        }

        return diff.size() == 2 && s.charAt(diff.get(0)) == goal.charAt(diff.get(1)) && s.charAt(diff.get(1)) == goal.charAt(diff.get(0));
    }
}

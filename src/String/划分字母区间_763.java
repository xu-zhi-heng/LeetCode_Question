package String;
import java.util.ArrayList;
import java.util.List;
/**
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 *
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 *
 * 返回一个表示每个字符串片段的长度的列表。
 */
public class 划分字母区间_763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        if (s.length() == 0) return result;
        // 记录每一个字符最后出现的位置
        int[] last_index = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last_index[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 因为end是最大值，所有end之前的所有元素最后出现的位置都没有在end后面出现过
            end = Math.max(end, last_index[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}

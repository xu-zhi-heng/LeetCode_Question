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
        char[] char_counts = new char[26];
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {

        }
        return result;
    }
}

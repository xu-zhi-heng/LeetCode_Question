package Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 */
public class 独一无二的出现次数_1207 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (list.contains(entry.getValue())) {
                return false;
            } else {
                list.add(entry.getValue());
            }
        }
        return true;
    }
}

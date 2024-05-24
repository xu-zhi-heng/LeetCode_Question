package Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 拆分成最多数目的正偶数之和_2178 {
    public static void main(String[] args) {
        maximumEvenSplit(90);
    }
    public static List<Long> maximumEvenSplit_02(long finalSum) {
        if (finalSum % 2 > 0) {
            return new ArrayList<>();
        }
        List<Long> result = new ArrayList<>();
        for (long i = 2; i <= finalSum; i = i + 2) {
            result.add(i);
            finalSum = finalSum - i;
        }
        result.set(result.size() - 1,  result.get(result.size() - 1) + finalSum);
        return result;
    }
    public static List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 > 0) {
            return new ArrayList<>();
        }
        HashMap<Long, List<List<Long>>> memory = new HashMap<>();
        List<List<Long>> lists = all_Construct(finalSum, memory);
        int maxLength = 0;
        int index = 0;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).size() > maxLength) {
                maxLength = lists.get(i).size();
                index = i;
            }
        }
        return lists.get(index);
    }
    public static List<List<Long>> all_Construct(long finalSum, HashMap<Long, List<List<Long>>> memory) {
        if (memory.containsKey(finalSum)) return memory.get(finalSum);
        if (finalSum == 0) return new ArrayList<>(Arrays.asList(new ArrayList<>()));
        List<List<Long>> result = new ArrayList<>();
        for (long num = 2; num <= finalSum; num = num + 2) {
            long suffix = finalSum - num;
            List<List<Long>> suffixWays = all_Construct(suffix, memory);
            List<List<Long>> targetWays = new ArrayList<>();
            for (List<Long> suffixWay : suffixWays) {
                List<Long> temp = new ArrayList<>(suffixWay);
                if (!temp.contains(num)) {
                    temp.add(num);
                    targetWays.add(temp);
                }
            }
            result.addAll(targetWays);
        }
        memory.put(finalSum, result);
        return result;
    }
}

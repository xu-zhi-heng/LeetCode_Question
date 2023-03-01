package Array;

import java.util.*;

public class 合并相似的物品_2363 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> result = new ArrayList<>();

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < items1.length; i++) {
            int value = items1[i][0];
            int weight = items1[i][1];
            hashMap.put(value, hashMap.getOrDefault(value, 0) + weight);
        }

        for (int i = 0; i < items2.length; i++) {
            int value = items2[i][0];
            int weight = items2[i][1];
            hashMap.put(value, hashMap.getOrDefault(value, 0) + weight);
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            List<Integer> list = new ArrayList<>();
            list.add(entry.getKey());
            list.add(entry.getValue());
            result.add(list);
        }

        Collections.sort(result, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });

        return result;
    }
}

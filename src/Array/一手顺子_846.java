package Array;
import java.util.TreeMap;

public class 一手顺子_846 {
    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        // TreeMap是一种可以排序的哈希表
        // 将每一个元素出现的次数存入到treeMap中
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : hand) {
            if (!treeMap.containsKey(num)) {
                treeMap.put(num, 1);
            } else {
                treeMap.put(num, treeMap.get(num) + 1);
            }
        }

        // 从最小的元素开始， 每次递增 1 直到 groupSize 的大小
        while (!treeMap.isEmpty()) {
            Integer key = treeMap.firstKey();
            int end = key + groupSize;
            for (int i = key; i < end; i++) {
                if (treeMap.containsKey(i)) {
                    if (treeMap.get(i) == 1) {
                        treeMap.remove(i);
                    } else {
                        treeMap.put(i, treeMap.get(i) - 1);
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

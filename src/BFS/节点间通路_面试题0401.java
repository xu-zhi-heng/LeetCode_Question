package BFS;

import java.util.*;

/**
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 */
public class 节点间通路_面试题0401 {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int[] ints : graph) {
            if (hashMap.containsKey(ints[0])) {
                List<Integer> list = hashMap.get(ints[0]);
                list.add(ints[1]);
                hashMap.put(ints[0], list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(ints[1]);
                hashMap.put(ints[0], list);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == target) {
                return true;
            }
            if (hashMap.containsKey(current)) {
                List<Integer> list = hashMap.get(current);
                for (Integer integer : list) {
                    queue.offer(integer);
                }
            }
        }
        return false;
    }
}

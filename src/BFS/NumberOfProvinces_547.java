package BFS;

import java.util.*;

public class NumberOfProvinces_547 {
    public static void main(String[] args) {
        int[][] isConnected = new int[][]{
                {1,0,0},
                {0,1,0},
                {0,0,1}
        };
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        int ans = 0;
        int n = isConnected.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> nodes = new ArrayList<>();
            graph.put(i + 1, nodes);
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    nodes.add(j + 1);
                }
            }
        }
        boolean[] visited = new boolean[n + 1];
        Set<Integer> set = graph.keySet();
        for (int node : set) {
            if (!visited[node]) {
                Deque<Integer> deque = new LinkedList<>();
                deque.offer(node);
                visited[node] = true;
                while (!deque.isEmpty()) {
                    Integer poll = deque.poll();
                    List<Integer> list = graph.get(poll);
                    for (int v : list) {
                        if (!visited[v]) {
                            deque.offer(v);
                            visited[v] = true;
                        }
                    }
                }
                ans++;
            }
        }
        return ans;
    }
}

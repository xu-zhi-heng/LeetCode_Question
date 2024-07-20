package BFS;

import java.util.*;

public class MinScoreOfPathBetweenTwoCities_2492 {
    public static void main(String[] args) {
        int[][] roads = new int[][]{
                {4,5,7468},
                {6,2,7173},
                {6,3,8365},
                {2,3,7674},
                {5,6,7852},
                {1,2,8547},
                {2,4,1885},
                {2,5,5192},
                {1,3,4065},
                {1,4,7357},
        };
        System.out.println(minScore(6, roads));
    }

    static List<int[]>[] graph;
    static int result = Integer.MAX_VALUE;
    public static int minScore(int n, int[][] roads) {
        graph = new ArrayList[n + 5];
        Arrays.setAll(graph, value -> new ArrayList<>());
        for (int i = 0; i < roads.length; i++) {
            graph[roads[i][0]].add(new int[]{roads[i][1], roads[i][2]});
            graph[roads[i][1]].add(new int[]{roads[i][0], roads[i][2]});
        }
        dfs(1);
        return result;
    }
    static Set<Integer> visited = new HashSet<>();
    public static void dfs(int i) {
        if (visited.contains(i)) {
            return;
        }
        visited.add(i);
        graph[i].forEach(item -> {
            result = Math.min(result, item[1]);
            dfs(item[0]);
        });
    }
}

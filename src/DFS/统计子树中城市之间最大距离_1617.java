package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 统计子树中城市之间最大距离_1617 {
    public static void main(String[] args) {
        countSubgraphsForEachDiameter(4, new int[][]{{1, 2}, {2, 3}, {2, 4}});
    }
    static int mask;
    static int diameter;
    public static int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int[] result = new int[n - 1];
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        // graph的每一个元素，代表当前下标 i + 1 节点 可以到达的下标 i 包含的所有元素 + 1 的节点
        for (int[] edge : edges) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            graph[x].add(y);
            graph[y].add(x);
        }
        // 1 << n 右移 n 位， 代表 2 ^ n 次方
        for (int i = 1; i < (1 << n); i++) {
            int root = 32 - Integer.numberOfLeadingZeros(i) - 1;
            System.out.println(root);
//            mask = i;
//            diameter = 0;
//            dfs(root, adj);
//            if (mask == 0 && diameter > 0) {
//                ans[diameter - 1]++;
//            }
        }


        return result;
    }


}

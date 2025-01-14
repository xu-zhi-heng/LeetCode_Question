package Stack;

import java.util.*;
import java.util.stream.Collectors;

public class FindBuildingWhereAliceAndBobCanMeet_2940 {
    public static void main(String[] args) {
        int[] heights = new int[]{1,2,1,2,1,2};
        int[][] queries = new int[][]{
//                {0,0},
                {1, 2},
//                {0,2},
//                {0,3},
//                {2,4},
//                {3,4},
//                {1,0},
//                {1,1},
//                {1,2},
//                {1,3},
//                {2,0},
//                {2,1},
//                {2,2},
//                {2,3},

//                {3,0},
//                {3,1},
//                {3,2},
//                {3,3},

        };
        int[] ints = leftmostBuildingQueries02(heights, queries);
        System.out.println(Arrays.toString(ints));
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        // 初始化结果数组为-1
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);

        // 创建一个列表，每个元素是一个列表，用于存储每个建筑对应的查询
        List<List<int[]>> qs = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            qs.add(new ArrayList<>());
        }

        // 预处理（离线阶段）
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (a > b) { // 确保 a <= b
                int temp = a;
                a = b;
                b = temp;
            }
            if (a == b || heights[a] < heights[b]) {
                ans[i] = b; // a 可以直接跳到 b
            } else { // 将最大高度存储到靠后的组
                qs.get(b).add(new int[] {heights[a], i});
            }
        }

        // 使用最小堆（在线阶段）
        PriorityQueue<int[]> h = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < heights.length; i++) {
            while (!h.isEmpty() && h.peek()[0] < heights[i]) {
                // 堆顶的 heights[a] 可以跳到 heights[i]
                ans[h.poll()[1]] = i;
            }
            for (int[] q : qs.get(i)) { // 将当前组的查询加入到堆中
                h.add(q);
            }
        }
        return ans;
    }


    // 没通过
    public static int[] leftmostBuildingQueries02(int[] heights, int[][] queries) {
        int[] ans = new int[queries.length];
        Map<Integer, List<Integer>> distance = new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] > heights[i]) {
                    list.add(j);
                }
            }
            distance.put(i, list);
        }

        int index = 0;
        for (int i = 0; i < queries.length; i++) {
            int ai = queries[i][0];
            int bi = queries[i][1];
            if (ai == bi) {
                ans[index++] = ai;
                continue;
            }
            List<Integer> geAi = distance.get(ai);
            List<Integer> geBi =distance.get(bi);
            Set<Integer> union = new HashSet<>(geAi);
            union.addAll(geBi);
            int maxIndex = Math.max(ai, bi);
            int minIndex = Math.min(ai, bi);
            List<Integer> collect = union.stream().filter(item ->
                    (item >= maxIndex)).collect(Collectors.toList());
            ans[index++] = collect.stream().filter(item -> heights[item] > heights[minIndex]).findFirst().orElse(-1);
        }
        return ans;
    }
}

package Array;

import java.util.*;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class 合并区间_56 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[][]{
                {1, 4},
                {5, 6},
        })));
    }
    public static int[][] merge(int[][] intervals) {
        // 根据每一个区间的起使位置排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            // 末尾比开始还要小，那说明肯定不连续，所以直接加入
            if (list.size() == 0 || list.get(list.size() - 1)[1] < start) {
                list.add(new int[]{start, end});
            } else {
                // 比较末尾大的那个地方
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], end);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}

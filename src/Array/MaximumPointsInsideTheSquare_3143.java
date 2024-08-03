package Array;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class MaximumPointsInsideTheSquare_3143 {
    public static void main(String[] args) {
        int[][] points = new int[][]{
                {-2,2},
                {-2,-2},
                {1,1},
        };
        System.out.println(maxPointsInsideSquare(points, "abb"));
    }

    public static int maxPointsInsideSquare(int[][] points, String s) {
        int ans = 0;
        IntSummaryStatistics intSummaryStatistics =
                Arrays.stream(points).
                        flatMapToInt(Arrays::stream).map(Math::abs).summaryStatistics();
        int low = intSummaryStatistics.getMin();
        int high = intSummaryStatistics.getMax();
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            boolean isStandard = true;
            int[] hash = new int[26];
            int count = 0;
            for (int i = 0; i < points.length; i++) {
                int x = Math.abs(points[i][0]);
                int y = Math.abs(points[i][1]);
                if (x > mid || y > mid) {
                    continue;
                }
                if (hash[s.charAt(i) - 97] == 0) {
                    hash[s.charAt(i) - 97]++;
                    count++;
                } else {
                    isStandard = false;
                    break;
                }
            }
            if (isStandard) {
                low = mid + 1;
                ans = Math.max(ans, count);
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}

package PrefixSum;

public class 收集垃圾的最少总时间_2391 {
    public int garbageCollection(String[] garbage, int[] travel) {
        // 前缀和，用来计算每一站的时间
        int[] preSum = new int[travel.length + 1];
        for (int i = 0; i < travel.length; i++) {
            preSum[i + 1] = travel[i] + preSum[i];
        }

        int result = 0;

        // 房间的长度有多长，需要清理的时间就是多少，在不考虑行驶的情况下
        result += garbage[0].length();
        int M = 0;
        int P = 0;
        int G = 0;
        for (int i = 1; i < garbage.length; i++) {
            result += garbage[i].length();

            // 如果当前是包含M的，那么就要计算收 M 这个垃圾车， 从当前位置，但现在的位置所需要的时间和，就是前面计算的preSum
            if (garbage[i].contains("M")) {
                result += preSum[i] - preSum[M];
                M = i;
            }
            if (garbage[i].contains("P")) {
                result += preSum[i] - preSum[P];
                P = i;
            }
            if (garbage[i].contains("G")) {
                result += preSum[i] - preSum[G];
                G = i;
            }
        }

        return result;
    }
}

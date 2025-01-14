package Dynamic;

import java.util.HashMap;
import java.util.Map;

public class FindNumberOfWaysToReachTheKthStair_3154 {

    public static void main(String[] args) {
        System.out.println(waysToReachStair(1));
    }

    static Map<String, Integer> memory = new HashMap<>();
    public static int waysToReachStair(int k) {
        return search(k, 0, 1, 1);
    }

    public static int search(int k, int jump, int downCount, int cur) {
        if (cur > k + 1) {
            return 0;
        }

        String key = cur + "," + jump + "," + downCount;
        if (memory.containsKey(key)) {
            return memory.get(key);
        }

        int ans = cur == k ? 1 : 0;
        // 如果现在不在0处并且上一步的操作是向上走的，那可以像下走一步
        if (cur > 0 && downCount == 1) {
           ans += search(k, jump, 0, cur - 1);
        }
        ans += search(k, jump + 1, 1, cur + (int) Math.pow(2, jump));

        memory.put(key, ans);

        return ans;
    }

}

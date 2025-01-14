package Dynamic;

import java.util.HashMap;
import java.util.Map;

public class StudentAttendanceRecordII_552 {

    private static final int MOD = 1000000007;
    private static Map<String, Integer> memory = new HashMap<>();
    public static int checkRecord(int n) {
        return search(n, 0, 0);
    }

    public static int search(int n, int A, int L) {
        if (n == 0) {
            return 1;
        }
        String key = n + "," + A + "," + L;
        if (memory.containsKey(key)) {
            return memory.get(key);
        }

        int res = 0;
        // 现在是到场的状态，那么L就要置为0了
        res += search(n - 1, A, 0);
        res %= MOD;

        if (L < 2) {
            res += search(n - 1, A, L + 1);
            res %= MOD;
        }

        if (A < 1) {
            res += search(n - 1, A + 1, 0);
            res %= MOD;
        }

        memory.put(key, res);

        return res;
    }
}

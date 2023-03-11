package Dynamic;

import java.util.HashMap;

public class 整数替换_397 {
    public int integerReplacement(int n) {
        return dp(n, new HashMap<>());
    }

    public int dp(int n, HashMap<Integer, Integer> memory) {
        if (memory.containsKey(n)) {
            return memory.get(n);
        }
        if (n <= 1) {
            return 0;
        }
        if (n % 2 == 0) {
            memory.put(n, dp(n / 2, memory) + 1);
        } else {
            memory.put(n, 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1)));
        }
        return memory.get(n);
    }
}

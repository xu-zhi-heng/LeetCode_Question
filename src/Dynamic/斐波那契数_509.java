package Dynamic;

import java.util.HashMap;

public class 斐波那契数_509 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        HashMap<Integer, Long> memory = new HashMap<>();
        return (int) dynamicFib(n, memory);
    }

    public long dynamicFib(int n, HashMap<Integer, Long> memory) {
        if (memory.containsKey(n)) return memory.get(n);
        if (n <= 2) return 1;
        memory.put(n, dynamicFib(n - 1, memory) + dynamicFib(n - 2, memory)) ;
        return memory.get(n);
    }
}

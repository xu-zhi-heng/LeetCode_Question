package SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BeautifulBouquet_LCP68 {
    public static void main(String[] args) {
        int[] flowers = new int[]{1,2,3,2};
        // 1,2,3,2

//        int[] ints = Arrays.copyOfRange(flowers, 0, flowers.length);
//        System.out.println(Arrays.toString(ints));
        System.out.println(beautifulBouquet(flowers, 1));
    }

    public static int beautifulBouquet(int[] flowers, int cnt) {
        int ans = 0;
        int j = flowers.length;
        int i = 0;
        if (isBeautiful(flowers, cnt)) {
            return (1 + flowers.length) * flowers.length / 2;
        }
        while (j <= 0) {
            int[] copy = Arrays.copyOfRange(flowers, i, j);
            if (isBeautiful(copy, cnt)) {
                ans += (1 + copy.length) * copy.length / 2;
                i++;
                j++;
            } else {
                j--;
            }
        }
        return ans;
    }

    public static boolean isBeautiful(int[] flowers, int cnt) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int flower : flowers) {
            Integer countsOrDefault = counts.getOrDefault(flower, 0);
            countsOrDefault++;
            if (countsOrDefault > cnt) {
                return false;
            }
            counts.put(flower, countsOrDefault);
        }
        return true;
    }
}

package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class 水果成篮_904 {
    public static void main(String[] args) {
        int[] fruits = new int[]{0,1,2,2};
        System.out.println(totalFruit(fruits));
    }
    public static int totalFruit(int[] fruits) {
        int last_fruit = -1;
        int second_last_fruit = -1;
        int last_fruit_count = 0;
        int current_max = 0;
        int max = 0;
        for (int fruit : fruits) {
            if (fruit == last_fruit || fruit == second_last_fruit) {
                current_max++;
            } else {
                current_max = last_fruit_count + 1;
            }
            if (fruit == last_fruit) {
                last_fruit_count++;
            } else {
                last_fruit_count = 1;
            }
            if (fruit != last_fruit) {
                second_last_fruit = last_fruit;
                last_fruit = fruit;
            }
            max = Math.max(current_max, max);
        }
        return max;
    }

    public int totalFruit_02(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        int left = 0, ans = 0;
        for (int right = 0; right < n; ++right) {
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
            while (cnt.size() > 2) {
                cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
                if (cnt.get(fruits[left]) == 0) {
                    cnt.remove(fruits[left]);
                }
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}

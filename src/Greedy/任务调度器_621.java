package Greedy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 任务调度器_621 {
    public static void main(String[] args) {

    }

    public static int leastInterval(char[] tasks, int n) {
        char[] charMaps = new char[26];
        // 统计每个任务出现的次数
        for (char task : tasks) {
            charMaps[task - 'A']++;
        }

        // 找到任务出现次数最多的那个任务
        Arrays.sort(charMaps);
        // 贪心，以任务次数出现最多的作为标准，算出有多少的空现时间
        // -1 ： 因为最后一个任务的后面不需要在有任何的东西
        // AXX AXX A （后面是空的了）
        int max_val = charMaps[25] - 1;
        // 计算出空闲的部分有多少
        int idleSlots  = max_val * n;

        // 将剩余的元素依次填入到空闲的时间中
        for (int i = 24; i >= 0; i--) {
            // AXX AXX A
            // 其中能够填冲的部分只能 2 个， 也就是max_val的值，所有说 max_val 的值是极限，不能比它大
            idleSlots = idleSlots - Math.min(charMaps[i], max_val);
        }

        // 最后就是如果还有空闲的时间没有被安排任务，那也会被算作时间
        return idleSlots > 0 ? (tasks.length + idleSlots) : tasks.length;

    }
}

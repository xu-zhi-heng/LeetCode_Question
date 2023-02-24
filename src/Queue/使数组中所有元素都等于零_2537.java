package Queue;

import java.util.*;

/**
 * 给你一个非负整数数组 nums 。在一步操作中，你必须：
 *
 * 选出一个正整数 x ，x 需要小于或等于 nums 中 最小 的 非零 元素。
 * nums 中的每个正整数都减去 x。
 * 返回使 nums 中所有元素都等于 0 需要的 最少 操作数。
 */
public class 使数组中所有元素都等于零_2537 {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1, 5, 0, 3, 5}));
    }
    // 完全为了熟悉一下PriorityQueue
    public static int minimumOperations(int[] nums) {
        int counts = 0;
        // 优先队列， 会自动排序
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (num != 0) {
                queue.offer(num);
            }
        }
        while (!queue.isEmpty()) {
            int subNum = queue.poll();
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                list.add(queue.poll() - subNum);
            }
            for (int num : list) {
                if (num != 0) {
                    queue.offer(num);
                }
            }
            counts++;
        }

        return counts;
    }
}

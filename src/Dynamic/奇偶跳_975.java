package Dynamic;

import java.util.Map;
import java.util.TreeMap;

/**
 * 给定一个整数数组 A，你可以从某一起始索引出发，跳跃一定次数。在你跳跃的过程中，第 1、3、5... 次跳跃称为奇数跳跃，而第 2、4、6... 次跳跃称为偶数跳跃。
 *
 * 你可以按以下方式从索引 i 向后跳转到索引 j（其中 i < j）：
 *
 * 在进行奇数跳跃时（如，第 1，3，5... 次跳跃），你将会跳到索引 j，使得 A[i] <= A[j]，A[j] 是可能的最小值。如果存在多个这样的索引 j，你只能跳到满足要求的最小索引 j 上。
 * 在进行偶数跳跃时（如，第 2，4，6... 次跳跃），你将会跳到索引 j，使得 A[i] >= A[j]，A[j] 是可能的最大值。如果存在多个这样的索引 j，你只能跳到满足要求的最小索引 j 上。
 * （对于某些索引 i，可能无法进行合乎要求的跳跃。）
 * 如果从某一索引开始跳跃一定次数（可能是 0 次或多次），就可以到达数组的末尾（索引 A.length - 1），那么该索引就会被认为是好的起始索引。
 *
 * 返回好的起始索引的数量。
 */
public class 奇偶跳_975 {
    public static void main(String[] args) {
        System.out.println(oddEvenJumps(new int[]{2, 3, 1, 1, 4}));
    }
    // 超时
    public static int oddEvenJumps(int[] arr) {
        int count = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            if (i == arr.length - 1) {
                count++;
                break;
            }
            int current = i;
            int jumpCount = 1;
            int index = i;
            while (current <= arr.length - 1) {
                if (current == arr.length - 1) {
                    count++;
                    break;
                }
                if (jumpCount % 2 == 0) {
                    int maxValue = 0;
                    for (int j = current + 1; j <= arr.length - 1; j++) {
                        if (arr[j] <= arr[current] && arr[j] > maxValue) {
                            maxValue = arr[j];
                            index = j;
                        }
                    }
                    if (current == index) {
                        break;
                    } else {
                        current = index;
                    }
                } else {
                    int minValue = Integer.MAX_VALUE;
                    for (int j = current + 1; j <= arr.length - 1; j++) {
                        if (arr[j] >= arr[current] && arr[j] < minValue) {
                            minValue = arr[j];
                            index = j;
                        }
                    }
                    if (current == index) {
                        break;
                    } else {
                        current = index;
                    }
                }
                jumpCount++;
            }
        }
        return count;
    }

    public static int oddEvenJumpsByDY(int[] arr) {
        int good_starting_index_count = 1;
        int n = arr.length;

        boolean[] higher = new boolean[n];
        boolean[] lower = new boolean[n];

        // 动态规划，确定初始状态， 在末尾的时候是能够算的
        higher[n - 1] = true;
        lower[n - 1] = true;

        // treeMap： 元素对的数组下标是多少
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(arr[n - 1], n - 1);

        for (int i = n - 2; i >= 0; i--) {
            // ceilingEntry方法找到第一个大于或等于指定key的Map.Entry
            Map.Entry<Integer, Integer> higher_key_val_pair = treeMap.ceilingEntry(arr[i]);
            // floorEntry方法找到第一个小于或等于指定key的Map.Entry
            Map.Entry<Integer, Integer> lower_key_val_pair = treeMap.floorEntry(arr[i]);

            if (higher_key_val_pair != null) {
                higher[i] = lower[(int) higher_key_val_pair.getValue()];
            }
            if (lower_key_val_pair != null) {
                lower[i] = higher[(int) lower_key_val_pair.getValue()];
            }
            if (higher[i]) {
                good_starting_index_count++;
            }
            treeMap.put(arr[i], i);
        }
        return good_starting_index_count;
    }
}

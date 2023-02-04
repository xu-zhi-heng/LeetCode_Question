package BFS;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 */
public class 打开转盘锁_752 {
    public int openLock(String[] deadends, String target) {
        // 用hashset存储所有不能的情况
        HashSet<String> dead_ends = new HashSet<>(Arrays.asList(deadends));
        // 存储已经访问过的集合
        HashSet<String> visited = new HashSet<>();
        visited.add("0000");

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String lock_position = queue.poll();
                // 如果这个是死锁，就不在继续往下搜索
                if (dead_ends.contains(lock_position)) {
                    size--;
                    continue;
                }
                // 如果和目标值一样，就返回
                if (lock_position.equals(target)) {
                    return level;
                }
                // 对当前字符串的每一位进行旋转操作，有两种，加一或减一
                StringBuilder stringBuilder = new StringBuilder(lock_position);
                for (int i = 0; i < 4; i++) {
                    char current_position = stringBuilder.charAt(i);
                    String addOne = stringBuilder.substring(0, i) +
                            (Character.getNumericValue(current_position) == 9 ? 0 : Character.getNumericValue(current_position) + 1) +
                            stringBuilder.substring(i + 1);
                    String subOne = stringBuilder.substring(0, i) +
                            (Character.getNumericValue(current_position) == 0 ? 9 : Character.getNumericValue(current_position) - 1) +
                            stringBuilder.substring(i + 1);
                    if (!visited.contains(addOne) && !dead_ends.contains(addOne)) {
                        queue.offer(addOne);
                        visited.add(addOne);
                    }
                    if (!visited.contains(subOne) && !dead_ends.contains(subOne)) {
                        queue.offer(subOne);
                        visited.add(subOne);
                    }
                }
                size--;
            }
            level++;
        }
        return -1;
    }
}

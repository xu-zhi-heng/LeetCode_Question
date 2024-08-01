package BFS;

import java.util.*;

public class WaterAndJugProblem_365 {
    public static void main(String[] args) {
        System.out.println(canMeasureWater(3, 5, 4));
    }

    public static boolean canMeasureWater(int x, int y, int target) {
        if (x > y) {
            x = x ^ y;
            y = x ^ y;
            x = x ^ y;
        }
        Deque<int[]> deque = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        deque.offer(new int[]{0, 0});
        while (!deque.isEmpty()) {
            int[] poll = deque.poll();
            if (Arrays.stream(poll).anyMatch(item -> item == target) || poll[0] + poll[1] == target) {
                return true;
            }
            if (!visited.add(poll[0] + "," + poll[1])) {
                continue;
            }
            deque.offer(new int[]{x, poll[1]});
            deque.offer(new int[]{poll[0], y});
            deque.offer(new int[]{0, poll[1]});
            deque.offer(new int[]{poll[0], 0});
            if (poll[0] + poll[1] > y) {
                deque.offer(new int[]{x - (y - poll[1]), y});
            } else {
                deque.offer(new int[]{0, poll[0] + poll[1]});
            }
            if (poll[0] + poll[1] > x) {
                deque.offer(new int[]{x, poll[1] - (x - poll[0])});
            } else {
                deque.offer(new int[]{poll[0] + poll[1], 0});
            }
        }
        return false;
    }
}

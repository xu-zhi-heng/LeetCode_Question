package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 钥匙和房间_841 {
    public static void main(String[] args) {

    }


    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Integer> visited = new ArrayList<>();
        visited.add(0);

        LinkedList<List<Integer>> queen = new LinkedList<>();
        queen.add(rooms.get(0));

        while (!queen.isEmpty()) {
            List<Integer> current = queen.pollFirst();
            for (int room : current) {
                if (!visited.contains(room)) {
                    visited.add(room);
                    queen.add(rooms.get(room));
                }
            }
        }

        return visited.size() == rooms.size();
    }
}

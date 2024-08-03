package BFS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class EmployeeImportance_690 {

    public static void main(String[] args) {

    }

    public int getImportance(List<Employee> employees, int id) {
        int ans = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(id);
        while (!deque.isEmpty()) {
            Integer poll = deque.poll();
            for (Employee employee : employees) {
                if (employee.id == poll) {
                    ans += employee.importance;
                    List<Integer> subordinates = employee.subordinates;
                    deque.addAll(subordinates);
                }
            }
        }

        return ans;
    }
}

package List;

import java.util.HashSet;
import java.util.Set;

public class 环形链表_141 {
    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        System.out.println(hasCycle(node));
    }

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if(!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}

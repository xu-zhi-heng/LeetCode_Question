package List;

import java.util.ArrayList;
import java.util.List;

public class 重排链表_143 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> listNodes = new ArrayList<ListNode>();
        ListNode temp = head;
        // 将链表的每一个元素放入到list中
        while (temp != null) {
            listNodes.add(temp);
            temp = temp.next;
        }
        // listNodes中的头部和尾部
        int i = 0;
        int j = listNodes.size() - 1;

        while (i < j) {
            listNodes.get(i).next = listNodes.get(j);
            i++;
            // 说明到尾部了
            if (i == j) {
                break;
            }
            // 之前i++过，说明后一个指向的是第二个，以此类推
            listNodes.get(j).next = listNodes.get(i);
            j--;
        }
        listNodes.get(j).next = null;
    }

    // 找到中间节点，反转中间节点的后半部分，在合并
    public void reorderList_02(ListNode head) {
        // 找到中间节点
        if (head == null) return;

        ListNode middle = middleNode(head);

        ListNode after = middle.next;
        middle.next = null;

        // 反转后半部分链表
        after = reverseList(after);

        // 合并
        ListNode temp = head;
        mergeList(temp, after);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_temp;
        ListNode l2_temp;

        while (l1 != null && l2 != null) {
            l1_temp = l1.next;
            l2_temp = l2.next;

            l1.next = l2;
            l1 = l1_temp;

            l2.next = l1;
            l2 = l2_temp;
        }
    }
}

package List;

public class 排序链表_148 {
    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        root.next = new ListNode(2);
        root.next.next = new ListNode(4);
        root.next.next.next = new ListNode(6);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(1);
        root.next.next.next.next.next.next = new ListNode(7);
        root.next.next.next.next.next.next.next = new ListNode(8);
        sortList(root);
    }
    // 归并排序
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = null;
        ListNode slow = head;
        ListNode fast = head.next;
        // 找到中间位置
        while (fast.next != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        temp = slow.next;
        slow.next = null;

        // 继续分割
        ListNode left = sortList(head);
        ListNode right = sortList(temp);

        ListNode root = new ListNode(0);
        ListNode res = root;
        while (left != null && right != null) {
            if (left.val < right.val) {
                root.next = left;
                left = left.next;
            } else {
                root.next = right;
                right = right.next;
            }
            root = root.next;
        }
        root.next = left != null ? left : right;

        return res.next;
    }
}

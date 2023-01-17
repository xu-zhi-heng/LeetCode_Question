package List;

public class 链表的中间结点_876 {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);

        System.out.println(middleNode(root));
    }

    public static ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        int index = (len / 2) + 1;
        while (index > 1) {
            if (head != null) {
                head = head.next;
                index--;
            } else {
                return null;
            }
        }
        return head;

        // 第二种寻找中间的方法
//        ListNode node1 = head;
//        ListNode node2 = head;
//        while (node1 != null && node2.next != null) {
//            node1 = node1.next;
//            node2 = node2.next.next;
//        }
//
//        return node1;
    }
}

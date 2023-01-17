package List;

/**
 * 第19题: 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class 删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        removeNthFromEnd(node1, 2);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        // 获取整个链表的长度
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        temp = head;

        // 如果长度和要删除的位置相同，那么说明要删除的就是第一个结点，直接返回第一个结点后面的即可
        if(length == n) {
            return temp.next;
        }

        // 找到倒数第n个结点的前一个结点
        for (int i = 0; i < length - n - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }
}



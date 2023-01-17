package List;

/**
 * 61. 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class 旋转链表 {
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
        System.out.println(rotateRight(node1, 2));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null) {
            return head;
        }
        int length = 1;
        ListNode iter = head;
        // 先找到链表的最后一个位置，并计算链表的长度
        while (iter.next != null) {
            iter = iter.next;
            length++;
        }
        // 计算需要移动的次数
        int moveLength = length - k % length;
        // 如果移动的次数和链表的长度一样，则就不需要移动了
        if(moveLength == length) {
            return head;
        }
        // 将链表围成一个圈
        iter.next = head;
        while (moveLength-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }
}

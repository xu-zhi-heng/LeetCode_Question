package List;

public class 奇偶链表_328 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(oddEvenList(head));
    }

    public static ListNode oddEvenList(ListNode head) {
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        // 条件为什么是以偶数，而不是奇数，因为偶数在最后
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

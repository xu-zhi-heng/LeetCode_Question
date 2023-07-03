package List;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 */
public class 两数相加II_606 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode.toString());
        //7807

    }

    // 头插法
    public static ListNode reversal(ListNode head) {
        ListNode newHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        return newHead;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode head = new ListNode();
        head = ans;
        ListNode rev_l1 = reversal(l1);
        ListNode rev_l2 = reversal(l2);
        System.out.println(rev_l1.toString());
        System.out.println(rev_l2.toString());
        int sum = 0;
        int carry = 0;
        while (rev_l1 != null || rev_l2 != null || carry != 0) {
            if (rev_l1 != null) {
                sum = sum + rev_l1.val;
            }
            if (rev_l2 != null) {
                sum = sum + rev_l2.val;
            }
            ListNode cur = new ListNode();
            if (sum + carry >= 10) {
                cur.val = (sum + carry) - 10;
                carry = 1;
                sum = 0;
            } else {
                cur.val = sum + carry;
                carry = 0;
                sum = 0;
            }
            ans.next = cur;
            ans = ans.next;
            if (rev_l1 != null) {
                rev_l1 = rev_l1.next;
            }
            if (rev_l2 != null) {
                rev_l2 = rev_l2.next;
            }
        }
        return reversal(head.next);
    }
}

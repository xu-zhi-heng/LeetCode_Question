package List;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class 两数相加_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode result_head = result;

        int carry = 0;  // 进位
        while (l1 != null || l2 != null) {
            int l1_val = l1 == null ? 0 : l1.val;
            int l2_val = l2 == null ? 0 : l2.val;

            int current_sum = l1_val + l2_val + carry;
            carry = current_sum / 10;   // 判断是否大于10，然后求出进位值
            current_sum = current_sum % 10;
            result_head.next = new ListNode(current_sum);

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            result_head = result_head.next;
        }
        if (carry > 0) {
            result_head.next = new ListNode(carry);
        }
        return result.next;
    }
}

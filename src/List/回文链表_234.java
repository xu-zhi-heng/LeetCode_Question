package List;
import java.util.Objects;
import java.util.Stack;

public class 回文链表_234 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(1);
        System.out.println(isPalindrome_02(listNode));
    }

    // 使用栈
    public static boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        // 当head在改变时，temp是不会变动的
        ListNode temp = head;
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        while (temp != null) {
            if (stack.peek().val != temp.val) {
                return false;
            }
            stack.pop();
            temp = temp.next;
        }

        return true;
    }

    // 找到链表中间的位置，也就是回文开始的地方，然后反转后面的部分，进行比较
    public static boolean isPalindrome_02(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reversed(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public static ListNode reversed(ListNode slow) {
        ListNode prev = null;

        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        return prev;
    }
}

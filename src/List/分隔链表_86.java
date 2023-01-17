package List;


public class 分隔链表_86 {
    public static void main(String[] args) {
        // 1,4,3,2,5,2
        ListNode root = new ListNode(1);
        root.next = new ListNode(4);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(2);
        partition(root, 3);
    }

    public static ListNode partition(ListNode head, int x) {
        // 创建两个新的链表，一个放小于x的，一个放大于等于x的

        // 在迭代过程中，before一直会变，但是before_head会一直连续下去，所以为什么会需要两个ListNode
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = after_head.next;

        return before_head.next;
    }
}

package List;

/**
 *  83 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 */
public class 删除排序链表中的重复元素_83 {
    public static void main(String[] args) {

    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = cur.next;
        // 遍历整个链表
        while (next != null) {
            // 如果当前的值和下一个链表的值相等，那么就删除掉当前链表的下一个链表
            if(cur.val == next.val) {
                cur.next = next.next;
            }
            // 如果当前的链表和下一个链表的值不同，那么就将当前的链表指向改变
            if(cur.val != next.val) {
                cur = cur.next;
            }
            next = next.next;
        }
        return head;
    }
}



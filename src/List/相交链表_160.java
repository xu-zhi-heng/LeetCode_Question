package List;

public class 相交链表_160 {
    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null) {
            ListNode copyHeadB = headB;
            while (copyHeadB != null) {
                if(headA == copyHeadB) {
                    return headA;
                }
                copyHeadB = copyHeadB.next;
            }
            headA = headA.next;
        }
        return null;
    }
}

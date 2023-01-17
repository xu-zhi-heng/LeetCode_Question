package List;

import java.util.Stack;

/**
 * 24.两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * 时间超时，问题没有找到！！！
 */
public class 两两交换链表中的节点NOT {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(swapPairs(head));
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode newList = new ListNode(-1);
        while (head != null) {
            stack.push(head);
            if(stack.size() == 2) {
                for(int i = 0; i < 2; i++) {
                    newList.next = stack.pop();
                    newList = newList.next;
                }
            }
            head = head.next;
        }
        if(!stack.empty()) {
            newList.next = stack.pop();
        }
        return newList.next;
    }
}

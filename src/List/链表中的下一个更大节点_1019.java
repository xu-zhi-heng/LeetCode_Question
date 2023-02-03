package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 链表中的下一个更大节点_1019 {
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp = head;
        List<ListNode> listNodes = new ArrayList<>();
        Stack<Integer> stack = new Stack<Integer>();
        while (temp != null) {
            listNodes.add(temp);
            temp = temp.next;
        }
        int[] answer = new int[listNodes.size()];
        Arrays.fill(answer, 0);
        for (int i = 0; i < listNodes.size(); i++) {
            // 当前为入栈的元素值比栈顶的元素值大时
            while (!stack.isEmpty() && listNodes.get(i).val > listNodes.get(stack.peek()).val) {
                answer[stack.pop()] = listNodes.get(i).val;
            }
            stack.push(i);
        }
        return answer;
    }
}

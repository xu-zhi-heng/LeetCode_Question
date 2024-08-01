package BFS;

import java.util.Deque;
import java.util.LinkedList;

public class SumOfNodesWithEvenValuesGrandParent_1315 {
    public static void main(String[] args) {

    }

    public static int sumEvenGrandparent(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            if (poll.left != null) {
                if (poll.val % 2 == 0) {
                    if (poll.left.left != null) {
                        ans += poll.left.left.val;
                    }
                    if (poll.left.right != null) {
                        ans += poll.left.right.val;
                    }
                }
                deque.offer(poll.left);
            }
            if (poll.right != null) {
                if (poll.val % 2 == 0) {
                    if (poll.right.left != null) {
                        ans += poll.right.left.val;
                    }
                    if (poll.right.right != null) {
                        ans += poll.right.right.val;
                    }
                }
                deque.offer(poll.right);
            }
        }
        return ans;
    }
}

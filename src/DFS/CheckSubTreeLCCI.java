package DFS;

import java.util.Deque;
import java.util.LinkedList;

public class CheckSubTreeLCCI {
    public static void main(String[] args) {

    }

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(t1);
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            if (poll.val == t2.val && isSameTree(poll, t2)) {
                return true;
            }
            if (poll.left != null) {
                deque.offer(poll.left);
            }
            if (poll.right != null) {
                deque.offer(poll.right);
            }
        }
        return false;
    }

    public boolean isSameTree(TreeNode t1, TreeNode t2) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(t1);
        deque.offer(t2);
        while (!deque.isEmpty()) {
            TreeNode node1 = deque.poll();
            TreeNode node2 = deque.poll();
            if (node2 == null || node1.val != node2.val) {
                return false;
            }
            if (node1.left != null) {
                deque.offer(node1.left);
                deque.offer(node2.left);
            }
            if (node1.right != null) {
                deque.offer(node1.right);
                deque.offer(node2.right);
            }
        }
        return true;
    }
}

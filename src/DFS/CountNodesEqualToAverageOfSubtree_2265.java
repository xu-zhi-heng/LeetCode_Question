package DFS;

import java.util.Deque;
import java.util.LinkedList;

public class CountNodesEqualToAverageOfSubtree_2265 {
    public static void main(String[] args) {

    }


    public static int averageOfSubtree(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            int sum = sum(poll);
            int count = count(poll);
            int avg = (int) Math.floor(sum / count);
            if (poll.val == avg) {
                ans++;
            }
            if (poll.left != null) {
                deque.offer(poll.left);
            }
            if (poll.right != null) {
                deque.offer(poll.right);
            }
        }
        return ans;
    }

    public static int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + sum(node.left) + sum(node.right);
    }

    public static int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + count(node.left) + count(node.right);
    }
}

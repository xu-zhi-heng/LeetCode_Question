package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class 左叶子之和_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.left != null) {
                queue.offer(root.left);
                if (root.left.left == null && root.left.right == null) {
                    sum += root.left.val;
                }
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
        }
        return sum;
    }
}

package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class 单值二叉树_965 {
    public boolean isUnivalTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int singleValue = root.val;
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (singleValue != root.val) {
                return false;
            }
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
        }
        return true;
    }
}

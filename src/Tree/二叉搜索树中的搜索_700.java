package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉搜索树中的搜索_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.val == val) {
                return root;
            }
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
        }
        return null;
    }
}

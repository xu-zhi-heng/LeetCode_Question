package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉搜索树的范围和_938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.val >= low && root.val <= high) {
                sum = sum + root.val;
            }
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
        }

        return sum;
    }
}

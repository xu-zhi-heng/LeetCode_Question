package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 路径总和_112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<Integer> queueValue = new LinkedList<>();
        Queue<TreeNode> queueNode = new LinkedList<>();
        queueNode.offer(root);
        queueValue.offer(root.val);

        while (!queueNode.isEmpty()) {
            TreeNode currentNode = queueNode.poll();
            int currentValue = queueValue.poll();
            if (currentNode.left == null && currentNode.right == null) {
                if (currentValue == targetSum) {
                    return true;
                }
                continue;
            }
            if (currentNode.left != null) {
                queueNode.offer(currentNode.left);
                queueValue.offer(currentNode.left.val + currentValue);
            }
            if (currentNode.right != null) {
                queueNode.offer(currentNode.right);
                queueValue.offer(currentNode.right.val + currentValue);
            }
        }

        return false;
    }
}

package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class 层数最深叶子节点的和_1302 {
    public int deepestLeavesSum(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            result = 0;
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                result = result + currentNode.val;
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }
}

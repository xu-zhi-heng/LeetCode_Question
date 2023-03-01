package BFS;

import java.util.*;
// 没写完
public class 路径总和II_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueValue = new LinkedList<>();
        queueNode.offer(root);
        queueValue.offer(root.val);

        while (!queueNode.isEmpty()) {
            TreeNode currentNode = queueNode.poll();
            int currentValue = queueValue.poll();
            if (currentNode.left == null && currentNode.right == null) {
                if (currentValue == targetSum) {

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

        return result;
    }

}

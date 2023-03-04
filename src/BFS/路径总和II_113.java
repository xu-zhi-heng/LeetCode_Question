package BFS;

import java.util.*;
public class 路径总和II_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        HashMap<TreeNode, TreeNode> hashMap = new HashMap<>();

        Queue<TreeNode> queueNodes = new LinkedList<>();
        Queue<Integer> queueNums = new LinkedList<>();
        queueNodes.offer(root);
        queueNums.offer(0);

        while (!queueNodes.isEmpty()) {
            TreeNode node = queueNodes.poll();
            int sum = queueNums.poll() + node.val;
            // 是叶子节点
            if (node.left == null && node.right == null) {
                if (sum == targetSum) {
                    // 核心
                    List<Integer> list = new ArrayList<>();
                    TreeNode current = node;
                    while (current != null) {
                        list.add(current.val);
                        current = hashMap.get(current);
                    }
                    Collections.reverse(list);
                    result.add(list);
                }
            }
            if (node.left != null) {
                queueNodes.offer(node.left);
                queueNums.offer(sum);
                hashMap.put(node.left, node);
            }

            if (node.right != null) {
                queueNodes.offer(node.right);
                queueNums.offer(sum);
                hashMap.put(node.right, node);
            }
        }

        return result;
    }
}

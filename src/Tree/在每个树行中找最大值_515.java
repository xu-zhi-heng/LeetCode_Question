package Tree;

import java.util.*;

public class 在每个树行中找最大值_515 {
    public static void main(String[] args) {
        largestValues(new TreeNode(0));
    }

    public static List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int maxValue = Integer.MIN_VALUE;
            // 取出queue中的所有节点，比较大小，并把下一层的节点放入到queue中；
            while (len > 0) {
                TreeNode poll = queue.poll();
                maxValue = Math.max(poll.val, maxValue);
                len--;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            result.add(maxValue);
        }
        return result;
    }
}

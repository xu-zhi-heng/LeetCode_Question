package DFS;

import java.util.Deque;
import java.util.LinkedList;

public class PathsWithSumLCCI {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createBT(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});
        System.out.println(pathSum(root, 22));
    }

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            ans += dfs(poll, sum);
            if (poll.left != null) {
                deque.offer(poll.left);
            }
            if (poll.right != null) {
                deque.offer(poll.right);
            }
        }
        return ans;
    }

    public static int dfs(TreeNode node, int sum) {
        if (node == null) return 0;
        sum -= node.val;
        int count = sum == 0 ? 1 : 0;
        count += dfs(node.left, sum);
        count += dfs(node.right, sum);
        return count;
    }
}

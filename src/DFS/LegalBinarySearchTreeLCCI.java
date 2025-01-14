package DFS;

import java.util.Deque;
import java.util.LinkedList;

public class LegalBinarySearchTreeLCCI {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createBT(new Integer[]{2, 1, 3});
        System.out.println(isValidBST(tree));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            if (poll.left != null) {
                boolean left = left(poll.left, poll.val);
                if (!left) {
                    return false;
                }
                deque.offer(poll.left);
            }
            if (poll.right != null) {
                boolean right = right(poll.right, poll.val);
                if (!right) {
                    return false;
                }
                deque.offer(poll.right);
            }
        }
        return true;
    }

    public static boolean left(TreeNode leftRoot, int rootVal) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(leftRoot);
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            if (poll.val >= rootVal) {
                return false;
            }
            if (poll.left != null) {
                deque.offer(poll.left);
            }
            if (poll.right != null) {
                deque.offer(poll.right);
            }
        }
        return true;
    }

    public static boolean right(TreeNode leftRoot, int rootVal) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(leftRoot);
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            if (poll.val <= rootVal) {
                return false;
            }
            if (poll.left != null) {
                deque.offer(poll.left);
            }
            if (poll.right != null) {
                deque.offer(poll.right);
            }
        }
        return true;
    }

    public static boolean dfs(TreeNode root, int rooVal) {
        if (root == null) {
            return true;
        }




        return true;
    }
}

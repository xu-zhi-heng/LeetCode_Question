package BFS;

import java.util.Deque;
import java.util.LinkedList;

public class LCP装饰树_67 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.right = new TreeNode(6);
        expandBinaryTree(root);
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            System.out.println(poll.val);
            if (poll.left != null) {
                deque.offer(poll.left);
            }
            if (poll.right != null) {
                deque.offer(poll.right);
            }
        }
    }
    public static TreeNode expandBinaryTree(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            if (poll.val == -1) {
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
                continue;
            }
            if (poll.left != null) {
                TreeNode treeNode = new TreeNode(-1);
                treeNode.left = poll.left;
                poll.left = treeNode;
                deque.offer(treeNode);
            }
            if (poll.right != null) {
                TreeNode treeNode = new TreeNode(-1);
                treeNode.right = poll.right;
                poll.right = treeNode;
                deque.offer(treeNode);
            }
        }
        return root;
    }
}

package DFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTreeToGreaterSumTree_1038 {
    public static void main(String[] args) {
        // 4,1,6,0,2,5,7,null,null,null,3,null,null,null,8
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        TreeNode treeNode = bstToGst(root);

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(treeNode);
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
    public static TreeNode bstToGst(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            int newVal = dfs(root, poll.val);
            if (poll.left != null) {
                deque.offer(poll.left);
            }
            if (poll.right != null) {
                deque.offer(poll.right);
            }
            list.add(newVal);
        }
        int index = 0;
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            if (poll.left != null) {
                deque.offer(poll.left);
            }
            if (poll.right != null) {
                deque.offer(poll.right);
            }
            poll.val = list.get(index++);
        }
        return root;
    }

    public static int dfs(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }
        return (node.val >= val ? node.val : 0) +
                dfs(node.left, val) +
                dfs(node.right, val);
    }
}
